/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: BaseController.java 
 * @Prject: SMBMS-web
 * @Package: com.cn.smbms.controller.user 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月19日 下午3:48:50 
 * @version: V1.0   
 */
package com.cn.smbms.controller.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/** 
 * @ClassName: BaseController 
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月19日 下午3:48:50  
 */
public class BaseController {

	@InitBinder
	public void dateFormart(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
}
