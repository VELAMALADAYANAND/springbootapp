package com.demo.rest.entity;

import jakarta.persistence.Transient;

import com.demo.rest.dto.ProductDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reviews {
	@Id
	@Column(name="rev_id")
	private int reviewId;
	@Column(name="prod_id")
	private int productId;
	@Column(name="rating")
	private int rating;
	@Column(name="rev_des")
	private String reviewDescription;
	@Transient
	ProductDto productdto;
	public Reviews(ProductDto productdto) {
		super();
		this.productdto = productdto;
	}
	public ProductDto getProductdto() {
		return productdto;
	}
	public void setProductdto(ProductDto productdto) {
		this.productdto = productdto;
	}
	public Reviews(int reviewId, int productId, int rating, String reviewDescription) {
			super();
			this.reviewId = reviewId;
			this.productId = productId;
			this.rating = rating;
			this.reviewDescription = reviewDescription;
			
	}
	public Reviews() {
		
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReviewDescription() {
		return reviewDescription;
	}
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	
}
	

