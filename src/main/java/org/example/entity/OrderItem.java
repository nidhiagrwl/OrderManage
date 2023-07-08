package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private String id;
    private String orderid;
    private String productId;
    private String vendorId;
    private Integer quantity;
    private Double itemPrice;
}
