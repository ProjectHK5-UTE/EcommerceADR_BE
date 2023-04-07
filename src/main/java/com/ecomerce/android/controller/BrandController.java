package com.ecomerce.android.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.android.service.BrandService;
import com.ecomerce.android.dto.BrandDTO;
import com.ecomerce.android.model.Brand;




@RestController
@CrossOrigin
public class BrandController {
	@Autowired
	private BrandService productService;

//	@Autowired
//	private static BrandDTOMapper mapper_struct;
	
	
	@RequestMapping(value = "/show", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> showSize() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
	}

//	@RequestMapping(value = "/show-id", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//	public ResponseEntity<?> findById() {
//		System.out.println("------------------------");
//		Optional<Brand> test = productService.findById("1");
//		System.out.println(test.get().getBrand_ID());
//		@SuppressWarnings("static-access")
//		BrandDTO brand_1 = mapper_struct.INSTANCE.brandmap(test.get());
//		System.out.println("------------------------");
//		return ResponseEntity.status(HttpStatus.OK).body(brand_1);
//	}
}
