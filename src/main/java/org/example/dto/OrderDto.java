package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class OrderDto {
    private String orderId; // required in case of update order
    private List<Item> itemList;
    private String customerId;

}
