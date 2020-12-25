package com.talentica.code.calculator;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.talentica.code.enums.ProductTypeEnum;
import com.talentica.code.model.Product;

/**
 * Calculate amount for all
 * products
 * 
 * @author Sayantan Ganguly
 *
 */
public class BaseProductCalculator {

	/**
	 * Calculate and
	 * update the amounts
	 * for all products
	 * 
	 * @param productList
	 * @return List<Product>
	 */
	public List<Product> calculateAmountForProducts(List<Product> productList) {
		return productList.stream().map(product->calculateAmountForEachProduct(product)).collect(Collectors.toList());
	}
	
	
	/**
	 * Calculate VAT,  
	 * import tax and 
	 * product amount(based on quantity)
	 * for each product
	 * 
	 * @param product
	 * @return Product
	 */
	private Product calculateAmountForEachProduct(Product product){
		
		//Calculate and set product amount
		product.setBeforeAnyTaxAmount(new ProductAmountCalculator()
				.calculatProductAmount(product.getPerUnitAmount(), product.getQuantity()));
		
		//Calculate and set VAT amount
		if(product.getProductType().compareTo(ProductTypeEnum.OTHERS)==0){
			product.setVatAmount(new VATAmountCalculator().calculateVATAmount(product.getBeforeAnyTaxAmount()));
		}
		
		//Calculate and set import tax amount
		if(StringUtils.contains(product.getProductName(), "imported")){
			product.setImportTaxAmount(new ImportTaxAmountCalculator().calculateImportTaxAmount(product.getBeforeAnyTaxAmount()));
		}
		
		return product;
	}
	

}
