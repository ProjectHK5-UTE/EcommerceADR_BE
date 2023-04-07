package com.ecomerce.android.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_ID")
	private int imageId;

	private String path;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="update_at")
	private Timestamp updateAt;

	//bi-directional many-to-one association to Option
	@ManyToOne
	@JoinColumn(name="optionId")
	private Option option;
}