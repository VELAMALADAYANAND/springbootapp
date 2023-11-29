package com.demo.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rest.entity.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews,Integer> {

	Optional<Reviews> findByProductId(int productId);
}
