package com.ecomerce.android.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.android.model.Brand;
import com.ecomerce.android.responsitory.BrandReponsitory;
import com.ecomerce.android.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	BrandReponsitory brandReponsitory;

	public List<Brand> findAll() {
		return brandReponsitory.findAll();
	}


	public Optional<Brand> findById(Integer id) {
		return brandReponsitory.findById(id);
	}
}
