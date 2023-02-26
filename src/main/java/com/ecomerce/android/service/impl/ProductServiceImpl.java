package com.ecomerce.android.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.android.model.Product;
import com.ecomerce.android.responsitory.ProductReponsitory;
import com.ecomerce.android.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductReponsitory productReponsitory;

	public Product save( Product entity) {
		return productReponsitory.save(entity);
	}

	public List<Product> findAll() {
		return productReponsitory.findAll();
	}

	public Optional<Product> findById(Integer id) {
		return productReponsitory.findById(id);
	}

	public void delete(Product entity) {
		productReponsitory.delete(entity);
	}
	
	
}
