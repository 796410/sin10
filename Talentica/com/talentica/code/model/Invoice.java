package com.talentica.code.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

	List<Product> productList = new ArrayList<>();
	
	BigDecimal totalVatAmount = BigDecimal.ZERO;
	
	BigDecimal totalimportTaxAmount = BigDecimal.ZERO;
	
	BigDecimal totalAmount = BigDecimal.ZERO;
	
	BigDecimal netAmount = BigDecimal.ZERO;

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public BigDecimal getTotalVatAmount() {
		return totalVatAmount;
	}

	public void setTotalVatAmount(BigDecimal totalVatAmount) {
		this.totalVatAmount = totalVatAmount;
	}

	public BigDecimal getTotalimportTaxAmount() {
		return totalimportTaxAmount;
	}

	public void setTotalimportTaxAmount(BigDecimal totalimportTaxAmount) {
		this.totalimportTaxAmount = totalimportTaxAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
