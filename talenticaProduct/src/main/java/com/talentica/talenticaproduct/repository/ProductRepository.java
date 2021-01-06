package com.talentica.talenticaproduct.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.talentica.talenticaproduct.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	public Product findByProductId(Long productId);
	
	public Product findByProductName(String productName);
	
}
