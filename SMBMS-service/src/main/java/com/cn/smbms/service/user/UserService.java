/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UserService.java 
 * @Prject: SMBMS-service
 * @Package: com.cn.smbms.service.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月11日 下午3:52:38 
 * @version: V1.0   
 */
package com.cn.smbms.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.cn.smbms.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月11日 下午3:52:38
 */
public interface UserService {

	// 用户登录
	User login(String name, String pwd);

	// 分页查询
	PageInfo<User> pagination(String name, Integer role);

	// 添加用户信息
	Integer addUser(User user);

	// 删除用户
	Integer deleteUser(String userCode);

	// 修改
	Integer updateUser(User user);

	// 根据编号查询用户信息
	User getByCode(String userCode);

}
