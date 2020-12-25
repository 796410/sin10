package com.talentica.code;

import java.util.List;

import com.talentica.code.calculator.BaseProductCalculator;
import com.talentica.code.calculator.InvoiceAmountCalculator;
import com.talentica.code.converter.ProductConverter;
import com.talentica.code.data.BasketData;
import com.talentica.code.model.Invoice;
import com.talentica.code.model.Product;
import com.talentica.code.print.PrintInvoice;

/**
 * Invoice Generation for
 * products present in a basket
 * 
 * @author Sayantan Ganguly
 *
 */
public class Invoicing {
	
	public static void main(String[] args) throws Exception {
		//Call invoice generation method to generate
		//invoice for the products added in
		//a basket
		generateInvoice();
	}
	
	/**
	 * Read, calculate and generate
	 * invoice for products added
	 * in basket
	 * 
	 * @throws Exception
	 */
	public static void generateInvoice() throws Exception{
		//Get basket data from CSV file
		List<String> basketDataList = new BasketData().getCSVData();
		
		//Convert basketDataList to corresponding list of product type
		List<Product> productList = new ProductConverter().convertToProductList(basketDataList, "|");
		
		//Calculate amount for each item
		productList = new BaseProductCalculator().calculateAmountForProducts(productList);
		
		//Calculate the total amount
		Invoice invoice = new Invoice();
		invoice.setProductList(productList);
		new InvoiceAmountCalculator().calculate(invoice);
		
		//Print the invoice
		new PrintInvoice().printForProducts(invoice);
		
		
	}

}
