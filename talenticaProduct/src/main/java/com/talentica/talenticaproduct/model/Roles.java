package com.talentica.talenticaproduct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "Roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;
	
	@Column(name = "role_name")
	private String roleName = StringUtils.EMPTY;
	
	@Column(name = "created_by")
	private String createdBy = StringUtils.EMPTY;
	
	@Column(name = "updated_by")
	private String updatedBy = StringUtils.EMPTY;
	
	@Column(name = "creation_date")
	private String creationDate = StringUtils.EMPTY;
	
	@Column(name = "updation_date")
	private String updationDate = StringUtils.EMPTY;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(String updationDate) {
		this.updationDate = updationDate;
	}

}
