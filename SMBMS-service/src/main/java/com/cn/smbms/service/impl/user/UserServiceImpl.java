/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UserServiceImpl.java 
 * @Prject: SMBMS-service
 * @Package: com.cn.smbms.service.impl.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月11日 下午3:54:38 
 * @version: V1.0   
 */
package com.cn.smbms.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.smbms.dao.user.UserDao;
import com.cn.smbms.entity.User;
import com.cn.smbms.service.user.UserService;
import com.github.pagehelper.PageInfo;

/** 
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月11日 下午3:54:38  
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User login(String name, String pwd) {
		return userDao.login(name, pwd);
	}

	
	public PageInfo<User> pagination(String name, Integer role) {
		PageInfo<User> list = new PageInfo<User>
		(userDao.pagination(name, role));
		return list;
	}

	public Integer addUser(User user) {
		return userDao.addUser(user);
	}

	public Integer deleteUser(String userCode) {
		return userDao.deleteUser(userCode);
	}

	public Integer updateUser(User user) {
		return userDao.updateUser(user);
	}

	public User getByCode(String userCode) {
		return userDao.getByCode(userCode);
	}

	
	

}
