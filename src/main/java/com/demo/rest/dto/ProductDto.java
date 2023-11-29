package com.demo.rest.dto;

public class ProductDto {
	private int productId;
	private String productName;
	private String productDescription;
	private int productQuantity;
	public ProductDto(double price) {
		this.productPrice = price;
	}
	private double productPrice;
	public double getPrice() {
		return productPrice;
	}
	public void setPrice(double price) {
		this.productPrice = price;
	}
	public ProductDto() {
		
	}
	public ProductDto(int productId, String productName, String productDescription, int productQuantity) {
	
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	

}
