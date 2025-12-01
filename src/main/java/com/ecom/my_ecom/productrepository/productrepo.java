package com.ecom.my_ecom.productrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ecom.my_ecom.entities.products;

// this is used for communicating with database and other tools which useing like a postman and browser...etc
public interface productrepo extends JpaRepository<products, Long> ,JpaSpecificationExecutor<products>{

}
