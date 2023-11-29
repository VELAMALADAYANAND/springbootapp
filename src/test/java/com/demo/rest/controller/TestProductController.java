package com.demo.rest.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.demo.rest.controller.ProductController;
import com.demo.rest.entity.Product;
import com.demo.rest.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest(ProductController.class)
class TestProductController {
	@MockBean
	ProductService productService;
	@Autowired
	MockMvc mockMvc;
	
	@Test
	

		public void getAllProductsTest() throws Exception

		{
			List<Product> plist= Arrays.asList(new Product(7001,"Lux Soap","Toilet Soap",15,50),
					new Product (7002,"Parachute Oil","Coconut Oil",115,250));
					when(productService.getAllProducts()).thenReturn(plist);
					mockMvc.perform(get("/product")	
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());


		}
	@Test
	public void addProductDetailsTest()throws JsonProcessingException,Exception {
		Product product =new Product(7001,"lux soap","body soap",15.40,5);
		when(productService.insertOrModifyProduct(product)).thenReturn(true);
		mockMvc.perform(post("/product")
		.contentType(MediaType.APPLICATION_JSON)
		.content(new ObjectMapper().writeValueAsString(product)))
		.andExpect(status().isOk());
		
	}
	@Test
	public void deleteProductByIdTest() throws Exception {
		int productId=7001;
		when(productService.deleteProductById(productId)).thenReturn(true);
		mockMvc.perform(delete("/product/{productId}",productId)
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
