/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UserController.java 
 * @Prject: SMBMS-web
 * @Package: com.cn.smbms.controller.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月11日 下午3:58:45 
 * @version: V1.0   
 */
package com.cn.smbms.controller.user;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.javassist.tools.framedump;
import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cn.smbms.entity.User;
import com.cn.smbms.result.Const;
import com.cn.smbms.result.Result;
import com.cn.smbms.service.user.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月11日 下午3:58:45
 */
@Api(description="用户控制器",value="UserController")
@Controller
@RequestMapping("user")
@SessionAttributes(value = { "userList", "totalPageCount", "totalCount", "currentPageNo", "queryname", "queryUserRole",
		"userSession" })
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@ApiOperation(value="login.jhtml",notes="登录接口",
			httpMethod="PUT")
	@RequestMapping("login.jhtml")
	@ResponseBody
	public Result<Object> login(
			@RequestBody Map<String, String> map) {
		if (map.isEmpty()) {
			return new Result<Object>(Const.FAILD,
					Const.MSG_FAILD,"请输入账号密码~~");
		}else {
			User user = userService.login(map.get("name"),
					map.get("pwd"));
			if (user == null) {
				return new Result<Object>(Const.FAILD,
						Const.MSG_FAILD,"账号密码错误~~");
			} else {
				// 设置视图名称
				return new Result<Object>(Const.SUCCESS,
						Const.MSG_SUCCESS,user);
			}
		}
	}

	@RequestMapping("list.jhtml")
	@ApiOperation(notes="分页查询用户信息",
	value="pagination",httpMethod="PUT")
	@ResponseBody
	public List<User> pagination(
			@RequestBody @RequestParam(value = "queryname", required = false) String name,
			@RequestBody @RequestParam(value = "queryUserRole", required = false) Integer role,
			@RequestBody @RequestParam(value = "pageIndex", required = false) Integer pageIndex)
			throws UnsupportedEncodingException {
		// 判断页码
		pageIndex = pageIndex == null ? 1 : pageIndex;
		// 设置分页属性
		PageHelper.startPage(pageIndex, 8);
		// 获取分页数据
		PageInfo<User> pageInfo = userService.pagination(name, role);
		/*// 将值存入session
		map.addAttribute("userList", pageInfo.getList());
		// 当前页
		map.addAttribute("currentPageNo", pageInfo.getPageNum());
		// 总计路数
		map.addAttribute("totalCount", pageInfo.getTotal());
		// 总页数
		map.addAttribute("totalPageCount", pageInfo.getPages());
		// 保存查询条件
		if (name != null) {
			map.addAttribute("queryname", name);
		}
		if (role != null) {
			map.addAttribute("queryUserRole", role);
		}*/
		// 返回视图
		return pageInfo.getList();
	}

	@RequestMapping(value = "add.jhtml", 
			method = { RequestMethod.GET, RequestMethod.POST })
	public String add(Model model,@RequestBody User user,
			MultipartFile[] muiltpart)
			throws IllegalStateException, IOException {
		if (user == null || user.getUserCode() == null) {
			return "useradd";
		} else {
			user.setCreationDate(new Date());
			user.setCreatedBy(1);
			// 对文件进行处理
			// 有文件上传需要处理
			for (int i = 0; i < muiltpart.length; i++) {
				if (!muiltpart[i].isEmpty()) {
					//获取request
					HttpServletRequest request = 
					((ServletRequestAttributes) RequestContextHolder.
							getRequestAttributes())
					.getRequest();
					// 获取到需要存储的路径
					String path = request.getRealPath("resources"+
							File.separator+"uploads"+
							File.separator+user.getUserCode());
					//获取文件名
					String name = muiltpart[i].getOriginalFilename();
					//获取后缀
					String prefix = FilenameUtils.getExtension(name);
					//图片格式验证
					if (prefix.equalsIgnoreCase("jpg")||
							prefix.equalsIgnoreCase("jpeg")||
							prefix.equalsIgnoreCase("png")||
							prefix.equalsIgnoreCase("gif")||
							prefix.equalsIgnoreCase("bmp")) {
						//重写文件名
						name = System.currentTimeMillis()+
						RandomUtils.nextInt(10000000)+"_csx.png";
						//开始复制文件
						File fileName = new File(path,name);
						//判断路径是否存在
						if (!fileName.exists()) {
							fileName.mkdirs();
						}
						//复制
						muiltpart[i].transferTo(fileName);
						//设置文件名
						if (i==0) {							
							user.setIdPicPath(name);
						}
						if (i==1) {
							user.setWorkPicPath(name);
						}
					}else if (muiltpart[i].getSize()>5242880) {
						//超出最大文件大小
						model.addAttribute("msg", "图片最大不能超过5M~~");
						return "useradd";
					}else {
						//上传失败
						model.addAttribute("msg", "对不起,请上传正确的图片格式~~");
						return "useradd";
					}
					//判断路径是否存在
				
				}
			}
			Integer result = userService.addUser(user);
			if (result > 0) {
				model.addAttribute("msg", "恭喜,添加成功~");
				return "forward:/user/list.jhtml";
			} else {
				model.addAttribute("msg", "对不起,添加失败~~");
				return "useradd";
			}
		}
	}

	@RequestMapping("view/{userCode}")
	public String getByCode(Model model, @PathVariable String userCode) {
		User user = userService.getByCode(userCode);
		if (user == null) {
			model.addAttribute("msg", "不存在此用户~~~");
			return "userlist";
		} else {
			model.addAttribute("user", user);
			return "userview";
		}
	}

	@RequestMapping("delete/{userCode}")
	public String deleteUser(Model model, @PathVariable String userCode) {
		Integer result = userService.deleteUser(userCode);
		if (result <= 0) {
			model.addAttribute("msg", "对不起,删除失败~~");
			return "userlist";
		} else {
			return "forward:/user/list.jhtml";
		}
	}
	
	//验证用户code是否可以使用
	@ResponseBody
	@RequestMapping(value="validateCode")
	public String validateCode(@RequestParam("userCode")String code) {
		JSONObject json = new JSONObject();
		//查询用户信息
		User user = userService.getByCode(code);
		if (user==null) {
			json.put("ret", true);
			json.put("data", "恭喜,该code可以使用~~");
		}else{
			json.put("ret", false);
			json.put("data", JSONObject.toJSONString(user));
		}
		return json.toJSONString();
	}

	
	
	
}
