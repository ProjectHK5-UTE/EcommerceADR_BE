package com.ecomerce.android.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="brand_ID")
	private String brand_ID;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String name;

	@Column(name="update_at")
	private Timestamp updateAt;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="brand")
	private List<Product> products;

	

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setBrand(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setBrand(null);

		return product;
	}

}