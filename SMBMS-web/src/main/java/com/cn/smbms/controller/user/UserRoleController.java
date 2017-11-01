/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UserRoleController.java 
 * @Prject: SMBMS-web
 * @Package: com.cn.smbms.controller.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月12日 下午5:03:40 
 * @version: V1.0   
 */
package com.cn.smbms.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cn.smbms.service.user.UserRoleService;

/** 
 * @ClassName: UserRoleController 
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月12日 下午5:03:40  
 */
@Controller
@RequestMapping("role")
@SessionAttributes(value={"roleList"})
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("list")
	public String list(ModelMap map){
		//将权限集合存入session
		map.addAttribute("roleList",userRoleService.getAll());
		return "userlist";
	}
	
	
	
	
	

}
