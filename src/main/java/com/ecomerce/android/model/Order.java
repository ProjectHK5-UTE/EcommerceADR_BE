package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int order_ID;

	@Column(name="created_at")
	private Timestamp createdAt;

	private Timestamp order_Date;

	@Column(name="total_amount")
	private double totalAmount;

	@Column(name="update_at")
	private Timestamp updateAt;

	//bi-directional many-to-one association to Lineitem
	@OneToMany(mappedBy="order")
	private List<Lineitem> lineitems;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_ID")
	private Customer customer;

	public Order() {
	}

	public int getOrder_ID() {
		return this.order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getOrder_Date() {
		return this.order_Date;
	}

	public void setOrder_Date(Timestamp order_Date) {
		this.order_Date = order_Date;
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public List<Lineitem> getLineitems() {
		return this.lineitems;
	}

	public void setLineitems(List<Lineitem> lineitems) {
		this.lineitems = lineitems;
	}

	public Lineitem addLineitem(Lineitem lineitem) {
		getLineitems().add(lineitem);
		lineitem.setOrder(this);

		return lineitem;
	}

	public Lineitem removeLineitem(Lineitem lineitem) {
		getLineitems().remove(lineitem);
		lineitem.setOrder(null);

		return lineitem;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}