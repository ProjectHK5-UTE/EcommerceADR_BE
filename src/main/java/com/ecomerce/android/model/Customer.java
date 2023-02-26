package com.ecomerce.android.model;

import java.io.Serializable;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int customer_ID;

	private String address;

	@Lob
	private byte[] avatar;

	private String email;

	private String fullname;

	private String phonenumber;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_ID")
	private User user;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer")
	private List<Order> orders;

	public Customer() {
	}

	public int getCustomer_ID() {
		return this.customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getAvatar() {
		return this.avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomer(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomer(null);

		return order;
	}

}