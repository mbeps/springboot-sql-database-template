package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class representing a product in the system.
 * 
 * @author Maruf Bepary
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	/** Unique identifier for the product */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** Name of the product */
	@Column(nullable = false, length = 100)
	private String name;

	/** Detailed description of the product */
	@Column(length = 500)
	private String description;

	/** Price of the product */
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	/** Timestamp when the product was created */
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	/** Timestamp when the product was last updated */
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	/**
	 * Sets initial timestamps when the product is created.
	 * 
	 * @author Maruf Bepary
	 */
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}

	/**
	 * Updates the timestamp when the product is modified.
	 * 
	 * @author Maruf Bepary
	 */
	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
}