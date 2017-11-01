/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: SwaggerConfig.java 
 * @Prject: SMBMS-web
 * @Package: com.cn.smbms.config 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月21日 上午10:06:53 
 * @version: V1.0   
 */
package com.cn.smbms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** 
 * @ClassName: SwaggerConfig 
 * @Description: TODO
 * @author: csx
 * @date: 2017年10月21日 上午10:06:53  
 */
@Configuration   //配置文件
@EnableSwagger2  //启用swagger2
@EnableWebMvc    //启用mvc注解
//swagger所识别的包
@ComponentScan(basePackages={"com.cn.smbms.controller"}) 
public class SwaggerConfig {

	//声明使用的api版本信息
	@Bean
	public Docket createApi() {
		return new Docket(DocumentationType.SWAGGER_2).
				apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Y2111超市管理系统")
				.description("©归Y2111所有")
				.contact(new Contact("csx", "", "yunkss@163.com"))
				.build();
	}
	
}
