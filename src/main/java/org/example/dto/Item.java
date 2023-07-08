package org.example.dto;

import lombok.Data;

@Data
public class Item {
    private String productId;
    private String vendorId;
    private Integer quantity;
    private Double itemPrice;
}
