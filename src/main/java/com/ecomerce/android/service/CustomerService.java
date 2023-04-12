package com.ecomerce.android.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CustomerService {
    String changeAvatar(String name, MultipartFile file) throws IOException;
}
