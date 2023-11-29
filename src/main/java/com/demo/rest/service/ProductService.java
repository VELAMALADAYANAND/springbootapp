package com.demo.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.rest.entity.Product;
import com.demo.rest.exception.ProductNotFoundException;
import com.demo.rest.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Transactional(readOnly=true)
	public List<Product> getAllProducts()throws ProductNotFoundException
	{
		List<Product> plist= productRepository.findAll();
		if(!plist.isEmpty()) {
			return plist;
			
		}
		throw new ProductNotFoundException("No Products Found");
	}
	@Transactional(readOnly=true)
	public Product getProductByid(int productId)throws ProductNotFoundException {
		Optional<Product> op=productRepository.findById(productId);
		if(op.isPresent()) {
			return op.get();
		}
		throw new ProductNotFoundException("No Products Found with id "+productId);
	}
	@Transactional(readOnly=true)
	public Product getProductByName(String productName)throws ProductNotFoundException {
		Optional<Product> op=productRepository.findByProductName(productName);
		if(op.isPresent()) {
			return op.get();
		}
		throw new ProductNotFoundException("No Products Found with this name "+productName);
	}
	
	
	
	
	
	@Transactional(readOnly=false)
	public boolean insertOrModifyProduct(Product product) {
		Product p=productRepository.save(product);
		return p!=null;
	}
	@Transactional(readOnly=false)
	public boolean deleteProductById(int productId)throws ProductNotFoundException {
		long count=productRepository.count();
		productRepository.deleteById(productId);
		if(count>productRepository.count()) {
			return true;
		}
		throw new ProductNotFoundException("product with id "+productId+" not to delete");
	}

}
