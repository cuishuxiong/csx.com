/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UserRoleServiceImpl.java 
 * @Prject: SMBMS-service
 * @Package: com.cn.smbms.service.impl.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月12日 下午5:00:28 
 * @version: V1.0   
 */
package com.cn.smbms.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.smbms.dao.user.UserRoleDao;
import com.cn.smbms.entity.Role;
import com.cn.smbms.service.user.UserRoleService;

/** 
 * @ClassName: UserRoleServiceImpl 
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月12日 下午5:00:28  
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	public List<Role> getAll() {
		return userRoleDao.getAll();
	}

}
