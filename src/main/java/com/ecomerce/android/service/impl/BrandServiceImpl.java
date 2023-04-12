package com.ecomerce.android.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.ecomerce.android.config.uploadFile.IStorageService;
import com.ecomerce.android.dto.BrandDTO;
import com.ecomerce.android.mapper.Mapper;
import com.ecomerce.android.responsitory.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.ecomerce.android.model.Brand;
import com.ecomerce.android.responsitory.BrandReponsitory;
import com.ecomerce.android.service.BrandService;
import org.springframework.web.multipart.MultipartFile;


@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	BrandReponsitory brandReponsitory;

	@Autowired
	ProductReponsitory productReponsitory;

	@Autowired
	private IStorageService storageService;

	@Autowired
	private Mapper mapper;

	@Override
	public List<BrandDTO> findAll() {
		List<Object[]> objs = productReponsitory.getAllBrand();
		List<BrandDTO> listBrandDTO = brandReponsitory.findAll().stream()
				.map(brand -> mapper.convertTo(brand, BrandDTO.class))
				.collect(Collectors.toList());

		IntStream.range(0, objs.size())
				.forEach(i -> {
					listBrandDTO.get(i).setProductAmount(Integer.valueOf(objs.get(i)[0].toString()));
				});
		return listBrandDTO;
	}

	@Override
	public Optional<Brand> findById(Integer id) {
		return brandReponsitory.findById(id);
	}

	@Override
	public String getUrlFile(String filename) {
		Resource file = storageService.loadAsResource(filename);
		return file.getFilename();
	}
	@Override
	public String save(String name, MultipartFile file) {
		// Trường hợp thêm
		UUID uuid = UUID.randomUUID();
		String uuString = uuid.toString();
		String filename = storageService.getStorageFilename(file, uuString);
		storageService.store(file, filename); // Luu file
		byte[] resource;
		try {
			resource = file.getBytes();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}


		Brand brand = Brand.builder()
				.name(name)
				.logo(filename)
				.image_data(resource).build();
		/*
		*  if(...) // Update
		*		if(kiem tra file da có hay chua)
		* 			findbyId
		* 			if(da co hinh)
		* 				-- Xoa hinh
		* 			else // chua co
		*
		*
		*
		*/
		return brandReponsitory.save(brand) != null ? filename : "";
	}
}
