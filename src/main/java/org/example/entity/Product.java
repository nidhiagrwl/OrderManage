package org.example.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Data
public class Product {
    private String productId;
    private String name;
    private String description;
    private Double productPrice;

}
