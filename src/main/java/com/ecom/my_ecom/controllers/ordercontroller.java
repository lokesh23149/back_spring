package com.ecom.my_ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.my_ecom.entities.orders;
import com.ecom.my_ecom.reviewsdao.ordercreateddto;
import com.ecom.my_ecom.reviewsdao.requestorder;
import com.ecom.my_ecom.services.orderservices;



@RestController
@RequestMapping("/api/order")
public class ordercontroller {

	@Autowired
	private orderservices orderservice;

	@PostMapping
	public ResponseEntity<?> createorder(@RequestBody requestorder requestorder) {
		ordercreateddto ordercreted =  orderservice.createorder(requestorder);
		return ResponseEntity.ok().body(ordercreted);

	}
	
	@GetMapping("/{referenceID}")
	public ResponseEntity<?> getorder(@PathVariable String referenceID) {
	 orders order=	orderservice.getorder(referenceID);
	 	return  ResponseEntity.ok().body(order);
		
	}

}
