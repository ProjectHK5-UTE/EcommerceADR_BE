package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the lineitem database table.
 * 
 */
@Entity
@NamedQuery(name="Lineitem.findAll", query="SELECT l FROM Lineitem l")
public class Lineitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int lineitem_ID;

	@Column(name="created_at")
	private Timestamp createdAt;

	private double price;

	private int quantity;

	@Column(name="update_at")
	private Timestamp updateAt;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_ID")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_ID")
	private Product product;

	public Lineitem() {
	}

	public int getLineitem_ID() {
		return this.lineitem_ID;
	}

	public void setLineitem_ID(int lineitem_ID) {
		this.lineitem_ID = lineitem_ID;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}