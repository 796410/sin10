package com.talentica.code.calculator;

import java.math.BigDecimal;

/**
 * Calculate Product amount
 * 
 * @author Sayantan Ganguly
 *
 */
public class ProductAmountCalculator {

	/**
	 * Calculate Product amount
	 * 
	 * @param amount
	 * @param quantity
	 * @return BigDecimal
	 */
	public BigDecimal calculatProductAmount(BigDecimal amount, Integer quantity){
		BigDecimal productAmount = amount.multiply(new BigDecimal(quantity));
		return productAmount;
	}

}
