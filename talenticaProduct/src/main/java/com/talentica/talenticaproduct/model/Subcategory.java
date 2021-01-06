package com.talentica.talenticaproduct.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "Subcategory")
public class Subcategory implements Serializable {
	
	@Id
	@Column(name = "sub_category_name")
	private String subCategoryName = StringUtils.EMPTY;

	@Column(name = "created_by")
	private String createdBy = StringUtils.EMPTY;
	
	@Column(name = "updated_by")
	private String updatedBy = StringUtils.EMPTY;
	
	@Column(name = "creation_date")
	private String creationDate = StringUtils.EMPTY;
	
	@Column(name = "updation_date")
	private String updationDate = StringUtils.EMPTY;
	
	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
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
