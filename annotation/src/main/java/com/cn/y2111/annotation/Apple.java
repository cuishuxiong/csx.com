/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: Apple.java 
 * @Prject: annotation
 * @Package: com.cn.y2111.annotation 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年9月12日 下午10:23:30 
 * @version: V1.0   
 */
package com.cn.y2111.annotation;

import com.cn.y2111.annotation.FruitColor.color;

/** 
 * @ClassName: Apple 
 * @Description: TODO
 * @author: csx
 * @date: 2017年9月12日 下午10:23:30  
 */
public class Apple {

	@FruitName("Aple")
	private String appleName;
	
	@FruitColor(fruitColor=color.RED)
	private String appleColor;
	
	@FruitProvider(id=1,address="陕西延安",name="红富士")
	private String appleProvider;

	/**
	 * @return the appleName
	 */
	public String getAppleName() {
		return appleName;
	}

	/**
	 * @param appleName the appleName to set
	 */
	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	/**
	 * @return the appleColor
	 */
	public String getAppleColor() {
		return appleColor;
	}

	/**
	 * @param appleColor the appleColor to set
	 */
	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	/**
	 * @return the appleProvider
	 */
	public String getAppleProvider() {
		return appleProvider;
	}

	/**
	 * @param appleProvider the appleProvider to set
	 */
	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}
	
	public void displayName(){
        System.out.println("水果的名字是：苹果");
    }
	
}
