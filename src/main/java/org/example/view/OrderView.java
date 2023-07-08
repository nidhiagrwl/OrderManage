package org.example.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Order;
import org.example.entity.OrderItem;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderView {
   private Order order;
   private List<OrderItem> orderItems;
}
