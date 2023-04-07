package com.ecomerce.android.service;

import java.util.List;
import java.util.Optional;

import com.ecomerce.android.model.Brand;



public interface BrandService {

	List<Brand> findAll();

	Optional<Brand> findById(Integer id);

}