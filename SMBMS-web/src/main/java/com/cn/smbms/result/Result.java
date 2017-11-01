/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: Result.java 
 * @Prject: SMBMS-web
 * @Package: com.cn.smbms.result 
 * @Description: TODO
 * @author: csx   
 * @date: 2017年10月21日 上午10:47:42 
 * @version: V1.0   
 */
package com.cn.smbms.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * @ClassName: Result 
 * @Description: 结果封装类
 * @author: csx
 * @date: 2017年10月21日 上午10:47:42  
 */
@ApiModel(description="结果封装类",value="Result")
public class Result<T> {

	//请求状态码
	@ApiModelProperty(name="code",value="请求状态码")
	private String code = null;
	
	//结构标识
	@ApiModelProperty(name="msg",value="结果提示信息")
	private String msg = null;
	
	//返回数据
	@ApiModelProperty(name="data",value="所需要的数据")
	private T data = null;
	
	

	/** 
	 * @Title:Result
	 * @Description:TODO 
	 * @param code
	 * @param msg
	 * @param data 
	 */
	public Result(String code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/** 
	 * @Title:Result
	 * @Description:TODO 
	 * @param code
	 * @param msg 
	 */
	public Result(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
