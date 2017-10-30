/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: FruitProvider.java 
 * @Prject: annotation
 * @Package: com.cn.y2111.annotation 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年9月12日 下午10:21:02 
 * @version: V1.0   
 */
package com.cn.y2111.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: FruitProvider
 * @Description: TODO
 * @author: csx
 * @date: 2017年9月12日 下午10:21:02
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

	public int id() default -1;

	public String name() default "";

	public String address() default "";

}
