package com.ecomerce.android.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.*;


/**
 * The persistent class for the color database table.
 * 
 */
@Entity
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String color_ID;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String name;

	@Column(name="update_at")
	private Timestamp updateAt;

	public Color() {
	}

	public String getColor_ID() {
		return this.color_ID;
	}

	public void setColor_ID(String color_ID) {
		this.color_ID = color_ID;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

}