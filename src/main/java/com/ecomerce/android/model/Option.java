package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the options database table.
 * 
 */
@Entity
@Table(name="options")
@NamedQuery(name="Option.findAll", query="SELECT o FROM Option o")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int options_ID;

	private String color_ID;

	private String ram;

	private String rom;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="option")
	private List<Image> images;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_ID")
	private Product product;

	public Option() {
	}

	public int getOptions_ID() {
		return this.options_ID;
	}

	public void setOptions_ID(int options_ID) {
		this.options_ID = options_ID;
	}

	public String getColor_ID() {
		return this.color_ID;
	}

	public void setColor_ID(String color_ID) {
		this.color_ID = color_ID;
	}

	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return this.rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setOption(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setOption(null);

		return image;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}