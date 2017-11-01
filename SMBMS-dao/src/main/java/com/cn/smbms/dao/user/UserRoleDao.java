/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UserRoleDao.java 
 * @Prject: SMBMS-dao
 * @Package: com.cn.smbms.dao.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月12日 下午4:57:10 
 * @version: V1.0   
 */
package com.cn.smbms.dao.user;

import java.util.List;

import com.cn.smbms.entity.Role;

/** 
 * @ClassName: UserRoleDao 
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月12日 下午4:57:10  
 */
public interface UserRoleDao {

	List<Role> getAll();
	
}
