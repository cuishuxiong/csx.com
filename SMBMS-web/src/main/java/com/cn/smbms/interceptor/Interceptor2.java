/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: Interceptor1.java 
 * @Prject: SMBMS-web
 * @Package: com.cn.smbms.interceptor 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月21日 上午9:04:32 
 * @version: V1.0   
 */
package com.cn.smbms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * @ClassName: Interceptor1 
 * @Description: 拦截器1
 * @author: csx
 * @date: 2017年10月21日 上午9:04:32  
 */
public class Interceptor2 extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Interceptor2-------->preHandle");
		return super.preHandle(request, response, handler);
	}

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Interceptor2-------->postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Interceptor2-------->afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}

	
	
}
