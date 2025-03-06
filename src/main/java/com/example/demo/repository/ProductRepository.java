package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	// Find products by name containing the given string (case-insensitive)
	List<Product> findByNameContainingIgnoreCase(String name);

	// Find products with price less than the given amount
	List<Product> findByPriceLessThan(BigDecimal price);

	// Find products with price greater than the given amount, sorted by price
	// ascending
	List<Product> findByPriceGreaterThanOrderByPriceAsc(BigDecimal price);
}