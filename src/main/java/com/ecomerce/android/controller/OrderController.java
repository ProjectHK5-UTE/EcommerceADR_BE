package com.ecomerce.android.controller;

import com.ecomerce.android.dto.OrderDTO;
import com.ecomerce.android.dto.ResponseObject;
import com.ecomerce.android.model.Status;
import com.ecomerce.android.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<?> save(@RequestBody OrderDTO order) {
        if(orderService.saveOrder(order)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new ResponseObject("Success", "Update Order Successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("Failed", "Error", "")
        );
    }

    @GetMapping("/order")
    public ResponseEntity<?> getAllOrder() {
//        orderService.getAllOrder().forEach(System.out::println);
        return ResponseEntity.status(HttpStatus.OK).body(
                orderService.getAllOrder()
        );
    }

    @GetMapping("/order/{isASC}/{attribute}")
    public ResponseEntity<?> sortOrder(@PathVariable("isASC") boolean isASC,
                                       @PathVariable("attribute") String attribute) {
        return ResponseEntity.status(HttpStatus.OK).body(
                orderService.sortOrder(isASC, attribute)
        );
    }

    @GetMapping("/order/{username}")
    public ResponseEntity<?> getOrderByUsername(@PathVariable("username") String username) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByUsername(username));
    }

    @GetMapping("/order/update-status/{orderId}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable("orderId") Integer orderId,
                                          @PathVariable("status") Status status) {
        if(orderService.updateStatus(orderId, status) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Success", "Update Status Successfully", ""));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Error", "Order ID cannot exist in db", ""));
        }
    }

    @GetMapping("/order/getOrder/{status}")
    public ResponseEntity<?> getOrderByStatus(@PathVariable("status") Status status) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByStatus(status));
    }
}
