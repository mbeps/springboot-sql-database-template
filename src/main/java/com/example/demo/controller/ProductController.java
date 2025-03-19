package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * REST controller for managing product operations.
 *
 * @author Maruf Bepary
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	/**
	 * Product service instance
	 */
	private final ProductService productService;

	/**
	 * Gets all products.
	 *
	 * @return list of all products
	 */
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	/**
	 * Gets product by ID.
	 *
	 * @param id product identifier
	 * @return product if found, 404 if not found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Searches products by name.
	 *
	 * @param name product name to search
	 * @return list of matching products
	 */
	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
		return ResponseEntity.ok(productService.getProductsByName(name));
	}

	/**
	 * Finds products below specified price.
	 *
	 * @param price maximum price threshold
	 * @return list of qualifying products
	 */
	@GetMapping("/price-less-than")
	public ResponseEntity<List<Product>> getProductsCheaperThan(@RequestParam BigDecimal price) {
		return ResponseEntity.ok(productService.getProductsCheaperThan(price));
	}

	/**
	 * Creates new product.
	 *
	 * @param product product to create
	 * @return created product
	 */
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product savedProduct = productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}

	/**
	 * Updates existing product.
	 *
	 * @param id      product identifier
	 * @param product updated product data
	 * @return updated product if found, 404 if not found
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.getProductById(id)
				.map(existingProduct -> {
					product.setId(id);
					return ResponseEntity.ok(productService.saveProduct(product));
				})
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Deletes product.
	 *
	 * @param id product identifier
	 * @return 204 if deleted, 404 if not found
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		return productService.getProductById(id)
				.map(product -> {
					productService.deleteProduct(id);
					return ResponseEntity.noContent().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}