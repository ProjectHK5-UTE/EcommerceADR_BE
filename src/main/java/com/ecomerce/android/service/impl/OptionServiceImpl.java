package com.ecomerce.android.service.impl;

import com.ecomerce.android.mapper.Mapper;
import com.ecomerce.android.responsitory.OptionRepository;
import com.ecomerce.android.service.OptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private Mapper mapper;
   
    public Integer findProductIdByOptionId(Integer optionId) {
    	Integer productId = optionRepository.findProductIdByOptionId(optionId);
    	return mapper.convertTo(productId, Integer.class);
    }
}
