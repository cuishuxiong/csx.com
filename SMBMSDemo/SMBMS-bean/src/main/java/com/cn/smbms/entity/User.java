package com.cn.smbms.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="用户对象",value="User")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	@ApiModelProperty(name="id",value="用户编号")
	private Integer id; //id 
	@ApiModelProperty(name="userCode",value="用户编码")
	private String userCode; //用户编码
	@ApiModelProperty(name="userName",value="用户名称")
	private String userName; //用户名称
	@ApiModelProperty(name="userPassword",value="用户密码")
	private String userPassword; //用户密码
	@ApiModelProperty(name="gender",value="性别")
	private Integer gender;  //性别
	@ApiModelProperty(name="birthday",value="出生日期")
	private Date birthday;  //出生日期
	@ApiModelProperty(name="phone",value="电话")
	private String phone;   //电话
	@ApiModelProperty(name="address",value="地址")
	private String address; //地址
	@ApiModelProperty(name="userRole",value="用户角色")
	private Integer userRole;    //用户角色
	@ApiModelProperty(name="createdBy",value="创建者")
	private Integer createdBy;   //创建者
	@ApiModelProperty(name="creationDate",value="创建时间")
	private Date creationDate; //创建时间
	@ApiModelProperty(name="modifyBy",value="更新者")
	private Integer modifyBy;     //更新者
	@ApiModelProperty(name="modifyDate",value="更新时间")
	private Date modifyDate;   //更新时间
	
	private Integer age;//年龄
	
	private String userRoleName;    //用户角色名称
	//证件照
	private String idPicPath = null;
	//工作照
	private String workPicPath = null;
	
	/**
	 * @return the idPicPath
	 */
	public String getIdPicPath() {
		return idPicPath;
	}
	/**
	 * @param idPicPath the idPicPath to set
	 */
	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}
	/**
	 * @return the workPicPath
	 */
	public String getWorkPicPath() {
		return workPicPath;
	}
	/**
	 * @param workPicPath the workPicPath to set
	 */
	public void setWorkPicPath(String workPicPath) {
		this.workPicPath = workPicPath;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public Integer getAge() {
		/*long time = System.currentTimeMillis()-birthday.getTime();
		Integer age = Long.valueOf(time/365/24/60/60/1000).IntegerValue();*/
		Date date = new Date();
		Integer age = date.getYear()-birthday.getYear();
		return age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
