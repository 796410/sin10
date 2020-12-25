package com.talentica.code.calculator;

import java.math.BigDecimal;

/**
 * Calculate VAT amount
 * 
 * @author Sayantan Ganguly
 *
 */
public class VATAmountCalculator {

	/**
	 * Calculate VAT amount
	 * 
	 * @param amount
	 * @return BigDecimal
	 */
	public BigDecimal calculateVATAmount(BigDecimal amount){
		BigDecimal vatAmount = amount.multiply(new BigDecimal(125)).divide(new BigDecimal(1000));
		return vatAmount;
	}
}
