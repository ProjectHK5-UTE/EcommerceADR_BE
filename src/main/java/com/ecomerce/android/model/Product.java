package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int product_ID;

	private String cpu;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String description;

	private String gpu;

	private String origin;

	private String os;

	@Column(name="product_name")
	private String productName;

	private int status;

	@Column(name="update_at")
	private Timestamp updateAt;

	//bi-directional many-to-one association to Option
	@OneToMany(mappedBy="product")
	private List<Option> options;

	//bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name="brand_ID")
	private Brand brand;

	//bi-directional many-to-one association to Productdetail
	@OneToMany(mappedBy="product")
	private List<Productdetail> productdetails;

	public Product() {
	}

	public int getProduct_ID() {
		return this.product_ID;
	}

	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}

	public String getCpu() {
		return this.cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGpu() {
		return this.gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public List<Option> getOptions() {
		return this.options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Option addOption(Option option) {
		getOptions().add(option);
		option.setProduct(this);

		return option;
	}

	public Option removeOption(Option option) {
		getOptions().remove(option);
		option.setProduct(null);

		return option;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Productdetail> getProductdetails() {
		return this.productdetails;
	}

	public void setProductdetails(List<Productdetail> productdetails) {
		this.productdetails = productdetails;
	}

	public Productdetail addProductdetail(Productdetail productdetail) {
		getProductdetails().add(productdetail);
		productdetail.setProduct(this);

		return productdetail;
	}

	public Productdetail removeProductdetail(Productdetail productdetail) {
		getProductdetails().remove(productdetail);
		productdetail.setProduct(null);

		return productdetail;
	}

}