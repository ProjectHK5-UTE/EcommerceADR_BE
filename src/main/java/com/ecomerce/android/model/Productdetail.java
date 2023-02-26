package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the productdetail database table.
 * 
 */
@Entity
@NamedQuery(name="Productdetail.findAll", query="SELECT p FROM Productdetail p")
public class Productdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productdetail_ID;

	private String battery;

	@Column(name="camera_resolution")
	private String cameraResolution;

	private double price;

	@Column(name="screen_size")
	private String screenSize;

	@Column(name="screen_technology")
	private String screenTechnology;

	@Column(name="sim_slot")
	private int simSlot;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_ID")
	private Product product;

	public Productdetail() {
	}

	public int getProductdetail_ID() {
		return this.productdetail_ID;
	}

	public void setProductdetail_ID(int productdetail_ID) {
		this.productdetail_ID = productdetail_ID;
	}

	public String getBattery() {
		return this.battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getCameraResolution() {
		return this.cameraResolution;
	}

	public void setCameraResolution(String cameraResolution) {
		this.cameraResolution = cameraResolution;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getScreenSize() {
		return this.screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getScreenTechnology() {
		return this.screenTechnology;
	}

	public void setScreenTechnology(String screenTechnology) {
		this.screenTechnology = screenTechnology;
	}

	public int getSimSlot() {
		return this.simSlot;
	}

	public void setSimSlot(int simSlot) {
		this.simSlot = simSlot;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}