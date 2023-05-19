package com.ecomerce.android.service;

import com.ecomerce.android.dto.OptionDTO;
import com.ecomerce.android.model.Option;

public interface OptionService{
	Integer findProductIdByOptionId(Integer optionId);
}