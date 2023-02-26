package com.ecomerce.android.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecomerce.android.model.Product;

public interface ProductService {
	Product save(Product entity);

	List<Product> findAll();

	Optional<Product> findById(Integer id);

	void delete(Product entity);
}
