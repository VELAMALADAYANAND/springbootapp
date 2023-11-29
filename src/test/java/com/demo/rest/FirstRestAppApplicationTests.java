package com.demo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.rest.entity.Product;
import com.demo.rest.repository.ProductRepository;
import com.demo.rest.service.ProductService;

@SpringBootTest
class FirstRestAppApplicationTests {
	@Autowired
	ProductService productService;
	
	@MockBean
	ProductRepository productRepository;//we are not  using actual repository
	
	@Test
	void getAllProductTest() {
		List<Product> plist=Arrays.asList(new Product(7001,"lux soap","body soap",15.40,5),
				new Product(7002,"parachute","coconut oil",114.0,30));
		when(productRepository.findAll()).thenReturn(plist);
		assertEquals(2,productService.getAllProducts().size());
	}
	@Test
	public void insertOrModifyTest() {
		Product prod=new Product(7002,"parachute","coconut oil",114.0,30);
		when(productRepository.save(prod)).thenReturn(prod);
		assertEquals(true,productService.insertOrModifyProduct(prod));
	}
	@Test
	public void deleteProductById() {
		int productId=7001;
		//doNothing().when(productRepository.deleteById(productId)).thenReturn();
		assertEquals(true,productService.deleteProductById(productId));
	}

}
