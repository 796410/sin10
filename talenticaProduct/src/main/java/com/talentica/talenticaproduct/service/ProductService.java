package com.talentica.talenticaproduct.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talentica.talenticaproduct.model.Product;
import com.talentica.talenticaproduct.repository.ProductRepository;
import com.talentica.talenticaproduct.security.IAuthentication;

@Service
public class ProductService {
	
	@Autowired
	private IAuthentication authenticationFacade;

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public Product getByProductId(Long productId) {
		return productRepository.findByProductId(productId);
	}
	
	@Transactional
	public List<Product> getAllProduct() {
		List<Product> productList = new ArrayList<>();
		productRepository.findAll().iterator().forEachRemaining(prdct->productList.add(prdct));
		return productList;
	}

	@Transactional
	public Product getByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}

	@Transactional
	public boolean addProduct(Product product) {
		product.setCreatedBy(authenticationFacade.getAuthentication().getName());
		product.setUpdatedBy(authenticationFacade.getAuthentication().getName());
		product.setCreationDate(LocalDateTime.now().toString());
		product.setUpdationDate(LocalDateTime.now().toString());
		return productRepository.save(product) != null;
	}

	@Transactional
	public boolean updateProduct(Product product) {
		product.setUpdatedBy(authenticationFacade.getAuthentication().getName());
		product.setUpdationDate(LocalDateTime.now().toString());
		return productRepository.save(product) != null;
	}
	
	@Transactional
	public boolean deleteProduct(Long productId) {
		Product product = productRepository.findByProductId(productId);
		if(product!=null) {
			product.setProductStatus("CANCEL");
			return productRepository.save(product) != null;
		} else {
			return false;
		}
	}

}
