package com.ecomerce.android.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.ecomerce.android.model.Customer;
import com.ecomerce.android.responsitory.CustomerRepository;
import com.ecomerce.android.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    Cloudinary cloudinary;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String changeAvatar(String name, MultipartFile file) throws IOException {
        Map r = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", "olympic_flag"));
        String url = cloudinary.url().transformation(new Transformation().width(600).height(500).crop("limit")).generate("olympic_flag");
        Optional<Customer> customer = customerRepository.findById(name);
        if(customer.isPresent()) {
            // Có
            Customer customerUpdate = customer.get();
            customerUpdate.setAvatar(url);
            customerRepository.save(customerUpdate);
            return url;
        }
        else {
            return "";
        }
    }
}
