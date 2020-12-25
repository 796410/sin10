package com.talentica.code.calculator;

import java.math.BigDecimal;

import com.talentica.code.model.Invoice;

/**
 * Total amount calculator
 * for invoice
 * 
 * @author Sayantan Ganguly
 *
 */
public class InvoiceAmountCalculator {

	/**
	 * Calculate total amounts
	 * 
	 * @param invoice
	 */
	public void calculate(Invoice invoice) {
		invoice.setTotalAmount(invoice.getProductList().stream().map(product->product.getBeforeAnyTaxAmount())
				.reduce(BigDecimal.ZERO, BigDecimal::add));
		invoice.setTotalVatAmount(invoice.getProductList().stream().map(product->product.getVatAmount())
				.reduce(BigDecimal.ZERO, BigDecimal::add));
		invoice.setTotalimportTaxAmount(invoice.getProductList().stream().map(product->product.getImportTaxAmount())
				.reduce(BigDecimal.ZERO, BigDecimal::add));
		invoice.setNetAmount(invoice.getTotalAmount().add(invoice.getTotalVatAmount()).add(invoice.getTotalimportTaxAmount()));
	}

}
