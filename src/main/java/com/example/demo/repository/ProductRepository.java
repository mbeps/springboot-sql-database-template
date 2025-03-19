package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for Product entity operations
 * 
 * @author Maruf Bepary
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * Searches for products with names containing the specified string
	 * 
	 * @param name The search string to match against product names
	 * @return List of products with matching names
	 * @author Maruf Bepary
	 */
	List<Product> findByNameContainingIgnoreCase(String name);

	/**
	 * Finds products with price below the specified amount
	 * 
	 * @param price The maximum price threshold
	 * @return List of products cheaper than the given price
	 * @author Maruf Bepary
	 */
	List<Product> findByPriceLessThan(BigDecimal price);

	/**
	 * Finds products more expensive than the specified price
	 * 
	 * @param price The minimum price threshold
	 * @return List of products sorted by price in ascending order
	 * @author Maruf Bepary
	 */
	List<Product> findByPriceGreaterThanOrderByPriceAsc(BigDecimal price);
}