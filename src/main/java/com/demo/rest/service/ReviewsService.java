package com.demo.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.demo.rest.dto.ProductDto;
import com.demo.rest.entity.Product;
import com.demo.rest.entity.Reviews;
import com.demo.rest.exception.ReviewNotFoundException;
import com.demo.rest.repository.ReviewsRepository;

@Service
public class ReviewsService {
	@Autowired
	ReviewsRepository reviewsRepository;
	
	@Autowired
	RestTemplate restTemplete;
	
	@Transactional(readOnly=true)
	public List<Reviews> getAllReviews(){
		return reviewsRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Reviews getReviewsById(int reviewId){
		
		Optional<Reviews> optRev= reviewsRepository.findById(reviewId);

		if(optRev.isPresent()) {
			return optRev.get();
		}
		throw new ReviewNotFoundException("Review doesnot exist with id"+reviewId);
	}
	
	@Transactional(readOnly=true)
	public Reviews getReviewsByProductId(int productId){
		
		Optional<Reviews> optRev= reviewsRepository.findByProductId(productId);

		if(optRev.isPresent()) {
			
			Product p=restTemplete.getForEntity
					("http://localhost:8091/product/{productId}",Product.class,productId).getBody();
			Reviews r=optRev.get();
			r.setProductdto(new com.demo.rest.dto.ProductDto());
			r.getProductdto().setProductId(productId);
			r.getProductdto().setProductName(p.getProductName());
			r.getProductdto().setProductDescription(p.getProductDescription());
			r.getProductdto().setProductQuantity(p.getProductQuantity());
			r.getProductdto().setPrice(p.getProductPrice());
			return r;
		}
		throw new ReviewNotFoundException("review doesnot exist with id"+productId);
	}
}
