/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UserDao.java 
 * @Prject: SMBMS-dao
 * @Package: com.cn.smbms.dao.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月11日 下午3:49:05 
 * @version: V1.0   
 */
package com.cn.smbms.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.smbms.entity.User;

/**
 * @ClassName: UserDao
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月11日 下午3:49:05
 */
public interface UserDao {

	// 用户登录
	User login(@Param("name") String name, @Param("pwd") String pwd);
	
	//分页查询
	List<User> pagination(@Param("name")String name,
			@Param("role")Integer role);
	
	//添加用户信息
	Integer addUser(User user);
	
	//删除用户
	Integer deleteUser(String userCode);
	
	//修改
	Integer updateUser(User user);
	
	//根据编号查询用户信息
	User getByCode(String userCode);
	
	

}
