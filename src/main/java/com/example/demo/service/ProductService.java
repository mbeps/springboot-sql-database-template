package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing product operations.
 *
 * @author Maruf Bepary
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    /**
     * Repository for product data operations
     */
    private final ProductRepository productRepository;

    /**
     * Retrieves all products from the database
     *
     * @return List of all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Finds a product by its ID
     *
     * @param id The ID of the product to find
     * @return Optional containing the product if found
     */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Searches for products by name
     *
     * @param name The name to search for
     * @return List of products matching the name
     */
    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    /**
     * Finds products cheaper than specified price
     *
     * @param price Maximum price to search for
     * @return List of products cheaper than the specified price
     */
    public List<Product> getProductsCheaperThan(BigDecimal price) {
        return productRepository.findByPriceLessThan(price);
    }

    /**
     * Saves a product to the database
     *
     * @param product The product to save
     * @return The saved product
     */
    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Deletes a product by its ID
     *
     * @param id The ID of the product to delete
     */
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}