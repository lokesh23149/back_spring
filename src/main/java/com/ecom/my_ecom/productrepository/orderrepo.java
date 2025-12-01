package com.ecom.my_ecom.productrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ecom.my_ecom.entities.orders;


public interface orderrepo extends JpaRepository<orders, Long>,JpaSpecificationExecutor<orders> {

	Optional<orders> findByReferenceId(String referenceID);
		
		
	
}
