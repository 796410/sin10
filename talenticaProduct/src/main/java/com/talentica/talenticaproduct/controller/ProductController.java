package com.talentica.talenticaproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.talentica.talenticaproduct.annotation.JsonRequestMapping;
import com.talentica.talenticaproduct.model.Product;
import com.talentica.talenticaproduct.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@JsonRequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Product getByProductId(@PathVariable("id") Long productId) {
		return productService.getByProductId(productId);
	}
	
	@JsonRequestMapping(value = "/product", method = RequestMethod.GET)
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
	
	@JsonRequestMapping(value = "/product/name/{name}", method = RequestMethod.GET)
	public Product getByProductName(@PathVariable("name") String productName) {
		return productService.getByProductName(productName);
	}

	@JsonRequestMapping(value = "/product/add", method = RequestMethod.POST)
	public HttpStatus addproduct(@RequestBody Product product) {
		return productService.addProduct(product) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@JsonRequestMapping(value = "/product/update", method = RequestMethod.PUT)
	public HttpStatus updateproduct(@RequestBody Product product) {
		return productService.updateProduct(product) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

	@JsonRequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteProduct(@PathVariable("id") Long productId) {
		return productService.deleteProduct(productId) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
}
