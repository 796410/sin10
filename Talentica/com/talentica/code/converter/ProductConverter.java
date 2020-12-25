package com.talentica.code.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.talentica.code.exception.ConversionException;
import com.talentica.code.map.ProductTypeMap;
import com.talentica.code.model.Product;
import com.talentica.code.validators.ProductValidator;

/**
 * Converter class to convert basket data
 * string to product
 * 
 * @author Sayantan Ganguly
 *
 */
public class ProductConverter {
	
	/**
	 * Convert list of
	 * string to corresponding
	 * list of products
	 * 
	 * @param productListToConvert
	 * @param delimiter
	 * @return List<Product>
	 * @throws ConversionException
	 */
	public List<Product> convertToProductList(List<String> productListToConvert, String delimiter) throws ConversionException{
		if(CollectionUtils.isNotEmpty(productListToConvert)){
			List<Product> productList =  productListToConvert.stream().map(productString->
				convertStringToProduct(productString, delimiter)
			).collect(Collectors.toList());
			return productList;
		}
		return new ArrayList<>();
	}
	
	/**
	 * Convert String data
	 * to corresponding
	 * product
	 * 
	 * @param productString
	 * @param delimiter
	 * @return Product
	 * @throws ConversionException
	 */
	private Product convertStringToProduct(String productString, String delimiter) throws ConversionException {
		try {
			String[] productStringArray = StringUtils.split(productString, delimiter);
			new ProductValidator().validateProduct(productStringArray);
			Product product = new Product();
			product.setQuantity(Integer.valueOf(productStringArray[0]));
			product.setProductName(productStringArray[1]);
			ProductTypeMap.productTypeMap.keySet().stream()
			.filter(str->StringUtils.contains(product.getProductName(), str))
			.findFirst().ifPresent(productType->product.setProductType(ProductTypeMap.productTypeMap.get(productType)));
			product.setPerUnitAmount(new BigDecimal(productStringArray[3]));
			return product;
		} catch(Exception e){
			throw new ConversionException("Failed to convert String data value to Product", e);
		}
	}

}
