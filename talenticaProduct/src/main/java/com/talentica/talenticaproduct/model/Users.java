package com.talentica.talenticaproduct.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "Users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "user_name")
	private String userName = StringUtils.EMPTY;
	
	@Column(name = "user_password")
	private String userPassword = StringUtils.EMPTY;
	
	@Column(name = "user_status")
	private String userStatus = StringUtils.EMPTY;
	
	@Column(name = "created_by")
	private String createdBy = StringUtils.EMPTY;
	
	@Column(name = "updated_by")
	private String updatedBy = StringUtils.EMPTY;
	
	@Column(name = "creation_date")
	private String creationDate = StringUtils.EMPTY;
	
	@Column(name = "updation_date")
	private String updationDate = StringUtils.EMPTY;
	
	 @ManyToMany
     @JoinTable(
	     name = "Userroles",
	     joinColumns = @JoinColumn(name = "user_id"),
	     inverseJoinColumns = @JoinColumn(name = "role_id")
    )
	private Set<Roles> roles = new HashSet<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
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

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	

}
