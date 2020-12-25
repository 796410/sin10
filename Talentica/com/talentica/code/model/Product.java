package com.talentica.code.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.talentica.code.enums.ProductTypeEnum;

/**
 * Model class for product
 * 
 * @author Sayantan Ganguly
 *
 */
public class Product {
	
	Integer quantity;
	 
	String productName = StringUtils.EMPTY;
	
	ProductTypeEnum productType = ProductTypeEnum.OTHERS;
	
	BigDecimal perUnitAmount = BigDecimal.ZERO;
	
	BigDecimal beforeAnyTaxAmount = BigDecimal.ZERO;
	
	BigDecimal vatAmount = BigDecimal.ZERO;
	
	BigDecimal importTaxAmount = BigDecimal.ZERO;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductTypeEnum getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeEnum productType) {
		this.productType = productType;
	}

	public BigDecimal getPerUnitAmount() {
		return perUnitAmount;
	}

	public void setPerUnitAmount(BigDecimal perUnitAmount) {
		this.perUnitAmount = perUnitAmount;
	}

	public BigDecimal getBeforeAnyTaxAmount() {
		return beforeAnyTaxAmount;
	}

	public void setBeforeAnyTaxAmount(BigDecimal beforeAnyTaxAmount) {
		this.beforeAnyTaxAmount = beforeAnyTaxAmount;
	}

	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public BigDecimal getImportTaxAmount() {
		return importTaxAmount;
	}

	public void setImportTaxAmount(BigDecimal importTaxAmount) {
		this.importTaxAmount = importTaxAmount;
	}
	
	
	
}
