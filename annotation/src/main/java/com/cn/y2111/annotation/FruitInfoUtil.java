/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: FruitInfoUtil.java 
 * @Prject: annotation
 * @Package: com.cn.y2111.annotation 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年9月12日 下午10:27:23 
 * @version: V1.0   
 */
package com.cn.y2111.annotation;

import java.lang.reflect.Field;

/**
 * @ClassName: FruitInfoUtil
 * @Description: TODO
 * @author: csx
 * @date: 2017年9月12日 下午10:27:23
 */
public class FruitInfoUtil {

	public static void getFruitInfo(Class<?> clazz) {
		String strFruitName = " 水果名称：";
		String strFruitColor = " 水果颜色：";
		String strFruitProvicer = "供应商信息：";

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = field.getAnnotation(FruitName.class);
				strFruitName += fruitName.value();
				System.out.println(strFruitName);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				strFruitColor += fruitColor.fruitColor().toString();
				System.out.println(strFruitColor);
			} else if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
				strFruitProvicer += "供应商编号:" + fruitProvider.id() + "供应商名称:" + fruitProvider.name() + "供应商地址:"
						+ fruitProvider.address();
				System.out.println(strFruitProvicer);
			}
		}

	}

}
