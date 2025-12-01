package com.ecom.my_ecom.services;

import static org.springframework.data.jpa.domain.Specification.where;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.stereotype.Service;

import com.ecom.my_ecom.entities.productreviews;
import com.ecom.my_ecom.entities.products;
import com.ecom.my_ecom.productrepository.productrepo;
import com.ecom.my_ecom.productrepository.review_repository;
import com.ecom.my_ecom.reviewsdao.Reviewsdao;
import com.ecom.my_ecom.reviewsdao.imagesdao;
import com.ecom.my_ecom.reviewsdao.productdao;
import com.ecom.my_ecom.specifications.productsepc;

//this is user for services like function how to response with users
@Service
public class product_service {

	@Autowired
	private productrepo repo;

	@Autowired
	private review_repository review_repo;

	public Map<String, Object> productservices(int page, int size) {

		PageRequest pages = PageRequest.of(page, size);

		Page<products> datapage = repo.findAll(pages);
		List<productdao> productdto = datapage.stream().map(this::conterTodao).collect(Collectors.toList());

		Map<String, Object> maping = new HashMap<String, Object>();
		maping.put(" datapage", productdto);
		
		maping.put("totalpages", datapage.getTotalElements());

		return maping;

	}

	public productdao conterTodao(products products) {
		productdao productdao = new productdao();
		productdao.setId(products.getId());
		productdao.setCategory(products.getCategory());
		productdao.setDiscripsion(products.getDiscripsion());
		productdao.setNumofreviews(products.getNumofreviews());
		productdao.setPrice(products.getPrice());
		productdao.setSeller(products.getSeller());
		productdao.setStock(products.getStock());
		productdao.setName(products.getName());
		List<Reviewsdao> myreviews= products.getReviews()
				.stream()
				.map(review->{
			Reviewsdao myreview =new Reviewsdao();
			
			myreview.setProductid(review.getId());
			myreview.setComments(review.getComments());
			myreview.setRatings(review.getRatings());
			return myreview;
			
		}).collect(Collectors.toList());
		productdao.setReviews(myreviews);
		
		List<imagesdao> myimages=products.getImages()
				.stream().map(img->{imagesdao myImagesdao=new imagesdao();
				
				myImagesdao.setUrl(img.getPublicid());
				return myImagesdao;
				
				
				}).collect(Collectors.toList());
		productdao.setImages(myimages);
		
		return productdao;
	}

	public products getproductbyid(Long id) {

		return repo.findById(id).orElseThrow(() -> new RuntimeException("id is not founded :" + id));

	}

	@SuppressWarnings("removal")
	public List<products> searchproduct(String category, Double minPrice, Double maxPrice, String keywords,
			Double rating) {
		Specification<products> spec = where(productsepc.findcategory(category))
				.and(productsepc.findbyprice(minPrice, maxPrice)).and(productsepc.findbynameordiscripsion(keywords))
				.and(productsepc.findratings(rating));

		return repo.findAll(spec);

	}

	public void addReviews(Reviewsdao reviews) {

		products addproduct = repo.findById(reviews.getId())
				.orElseThrow(() -> new RuntimeException("id is not founded"));
		productreviews product_reviews = new productreviews();
		product_reviews.setComments(reviews.getComments());
		product_reviews.setRatings(reviews.getRatings());
		product_reviews.setProductreviews(addproduct);

		review_repo.save(product_reviews);

	}
	
	
	
	
	
}
