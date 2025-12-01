package com.ecom.my_ecom.productrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.my_ecom.entities.productreviews;

public interface review_repository extends JpaRepository<productreviews, Long> {

}
