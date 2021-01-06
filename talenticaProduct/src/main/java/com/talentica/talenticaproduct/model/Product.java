package com.talentica.talenticaproduct.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;


@Entity
@Table(name = "Product")
public class Product implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "product_name")
	private String productName = StringUtils.EMPTY;
	
	@ManyToOne
    @JoinColumn(name ="category_id")
	private Category category;
	
	@Column(name = "unit_price")
	private BigDecimal unitPrice = BigDecimal.ZERO;
	
	@Column(name = "size")
	private Integer size = 0;
	
	@Column(name = "color")
	private String color = StringUtils.EMPTY;
	
	@Column(name = "product_status")
	private String productStatus = StringUtils.EMPTY;
	
	@Column(name = "created_by")
	private String createdBy = StringUtils.EMPTY;
	
	@Column(name = "updated_by")
	private String updatedBy = StringUtils.EMPTY;
	
	@Column(name = "creation_date")
	private String creationDate = StringUtils.EMPTY;
	
	@Column(name = "updation_date")
	private String updationDate = StringUtils.EMPTY;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	

}
