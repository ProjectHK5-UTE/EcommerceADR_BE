package com.ecomerce.android.dto;

import com.ecomerce.android.model.Customer;
import com.ecomerce.android.model.Lineitem;
import com.ecomerce.android.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private int orderId;
    
    private double totalPrice;

    private Status status;

    private List<LineitemDTO> lineitems;

    private CustomerDTO customer;
    
    private Timestamp order_date;
}
