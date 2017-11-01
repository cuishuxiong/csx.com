package com.cn.smbms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="用户角色",value="Role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
	@ApiModelProperty(name="id",value="编号")
	private Integer id;   //id
	@ApiModelProperty(name="roleCode",value="角色编码")
	private String roleCode; //角色编码
	@ApiModelProperty(name="roleName",value="角色名称")
	private String roleName; //角色名称
	@ApiModelProperty(name="createdBy",value="创建者")
	private Integer createdBy; //创建者
	@ApiModelProperty(name="creationDate",value="创建时间")
	private Date creationDate; //创建时间
	@ApiModelProperty(name="modifyBy",value="更新者")
	private Integer modifyBy; //更新者
	@ApiModelProperty(name="modifyDate",value="更新时间")
	private Date modifyDate;//更新时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
