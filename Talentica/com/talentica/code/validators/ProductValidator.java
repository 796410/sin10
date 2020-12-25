package com.talentica.code.validators;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.talentica.code.exception.ConversionException;

/**
 * Validate the product
 * 
 * @author Sayantan Ganguly
 *
 */
public class ProductValidator {

	/**
	 * Validate values 
	 * for product
	 * 
	 * @param productStringArray
	 */
	public void validateProduct(String[] productStringArray) {
		if(Integer.valueOf(productStringArray[0]) <=0 ){
			throw new ConversionException("Quantity cannot be zero or negative");
		}
		if(StringUtils.isBlank(productStringArray[1])){
			throw new ConversionException("Product name cannot be blank");
		}
		if(new BigDecimal(productStringArray[3]).signum() <= 0){
			throw new ConversionException("Unit cost cannot be zero or negative");
		}
	}

}
