package com.ecomerce.android.controller;

import com.ecomerce.android.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // Change Avatar Customer - Cloud
    @PostMapping(value = "/change-avatar")
    public ResponseEntity<?> changeAvatar(@RequestParam("name") String name,
                                          @RequestParam("images") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.changeAvatar(name, file));
    }
}
