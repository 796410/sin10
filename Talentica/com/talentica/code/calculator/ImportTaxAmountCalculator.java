package com.talentica.code.calculator;

import java.math.BigDecimal;

/**
 * Calculate TAX amount
 * 
 * @author Sayantan Ganguly
 *
 */
public class ImportTaxAmountCalculator {

	/**
	 * Calculate TAX amount
	 * 
	 * @param amount
	 * @return BigDecimal
	 */
	public BigDecimal calculateImportTaxAmount(BigDecimal amount){
		BigDecimal importTaxAmount = amount.multiply(new BigDecimal(24)).divide(new BigDecimal(1000));
		return importTaxAmount;
	}

}
