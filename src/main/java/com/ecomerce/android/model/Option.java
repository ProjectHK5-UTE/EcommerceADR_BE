package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="options")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "options_ID")
	private Integer optionId;

	private String ram;

	private String rom;

	private Double price;

	private Integer status;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="option")
	private List<Image> images;

	@OneToMany(mappedBy="option")
	private List<Lineitem> lineitems;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;



}