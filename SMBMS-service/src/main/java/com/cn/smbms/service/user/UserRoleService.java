/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UserRoleService.java 
 * @Prject: SMBMS-service
 * @Package: com.cn.smbms.service.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月12日 下午4:59:25 
 * @version: V1.0   
 */
package com.cn.smbms.service.user;

import java.util.List;

import com.cn.smbms.entity.Role;

/** 
 * @ClassName: UserRoleService 
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月12日 下午4:59:25  
 */
public interface UserRoleService {
	
	List<Role> getAll();

}
