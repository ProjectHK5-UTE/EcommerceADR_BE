package com.ecomerce.android.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.android.service.ProductService;


@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/api/product/show-all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> showAllSize() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
	}

	@RequestMapping(value = "/api/product/show-id", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> findById() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.findById(1));
	}
}
