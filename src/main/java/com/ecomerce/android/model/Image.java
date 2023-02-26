package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int image_ID;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Lob
	private byte[] filebath;

	@Column(name="update_at")
	private Timestamp updateAt;

	//bi-directional many-to-one association to Option
	@ManyToOne
	@JoinColumn(name="options_ID")
	private Option option;

	public Image() {
	}

	public int getImage_ID() {
		return this.image_ID;
	}

	public void setImage_ID(int image_ID) {
		this.image_ID = image_ID;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public byte[] getFilebath() {
		return this.filebath;
	}

	public void setFilebath(byte[] filebath) {
		this.filebath = filebath;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public Option getOption() {
		return this.option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

}