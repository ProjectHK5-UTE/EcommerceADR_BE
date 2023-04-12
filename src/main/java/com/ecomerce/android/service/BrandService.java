package com.ecomerce.android.service;

import java.util.List;
import java.util.Optional;

import com.ecomerce.android.dto.BrandDTO;
import com.ecomerce.android.model.Brand;
import org.springframework.web.multipart.MultipartFile;


public interface BrandService {


	List<BrandDTO> findAll();

	Optional<Brand> findById(Integer id);

    String getUrlFile(String filename);

    String save(String name, MultipartFile file);
}