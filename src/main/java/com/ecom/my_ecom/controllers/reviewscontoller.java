package com.ecom.my_ecom.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.my_ecom.reviewsdao.Reviewsdao;
import com.ecom.my_ecom.services.product_service;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/products/reviews")

public class reviewscontoller {
	
	@Autowired
	private product_service pro_service;
	
	@PostMapping
	public ResponseEntity<?> addReviews(@RequestBody @Valid Reviewsdao reviews) {
		pro_service.addReviews(reviews);
		 return ResponseEntity.status(HttpStatus.CREATED).body("Review  is created");
		
	}

	
}
