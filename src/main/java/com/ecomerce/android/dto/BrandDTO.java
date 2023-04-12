package com.ecomerce.android.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {
//	private int brandId;
//	private String logo;
//	private byte[] image_data;
//	private Integer productAmount;

	private Integer brandId;

	private String name;

	private String logo;

	private byte[] image_data;

	private Integer productAmount;
}
