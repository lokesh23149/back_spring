package com.ecom.my_ecom.controllers;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.my_ecom.entities.products;
import com.ecom.my_ecom.services.product_service;

@RestController
@RequestMapping("/api/products")
public class productcontrol {
	@Autowired
	private product_service pro_service;

	@GetMapping
	public Map<String,Object> getallproduct(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5") int size) {
	
		return 	 pro_service.productservices(page,size);
	}
	@GetMapping("/{id}")
	public products getproductbyid(@PathVariable Long id) {
		return  pro_service.getproductbyid(id);
		
	}
	@GetMapping("/search")
	public List<products> getproductbysearch(@RequestParam(required = false) String category,@RequestParam(required = false) Double minPrice,@RequestParam(required = false) Double maxPrice,@RequestParam(required = false) String keywords,@RequestParam(required = false) Double ratings) {
		
		return pro_service.searchproduct(category,minPrice,maxPrice,keywords,ratings);
		
	}

}
