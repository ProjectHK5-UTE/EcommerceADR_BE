package com.ecomerce.android.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.android.service.OptionService;

@RestController
@RequestMapping("/api")
public class OptionController{
	@Autowired
	OptionService optionService;
	
	@GetMapping("/getProductId/{optionId}")
	public ResponseEntity<Integer> findProductIdByOptionId(@PathVariable("optionId") Integer optionId) {
        return ResponseEntity.status(HttpStatus.OK).body(optionService.findProductIdByOptionId(optionId));
    }
}