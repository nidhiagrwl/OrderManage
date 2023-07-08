package org.example.service;

import org.example.dto.Item;
import org.example.dto.OrderDto;
import org.example.entity.Order;
import org.example.entity.OrderItem;
import org.example.view.OrderView;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class OrderServiceImpl implements OrderService{



    List<OrderView> orderViewList=new ArrayList<>();





    @Override
    public OrderView createOrder(OrderDto order) throws Exception {
        OrderView orderView=new OrderView();
        try {
            Order newOrder=new Order();
            newOrder.setId(UUID.randomUUID().toString());
            newOrder.setCreatedDate(new Date());
            newOrder.setUpdatedDate(new Date());
            newOrder.setOrderStatus("PLACED");
            newOrder.setCustomerId(order.getCustomerId());
            orderView.setOrder(newOrder);


            List<Item> itemsList = order.getItemList();
            List<OrderItem> orderItemList=new ArrayList<>();

            for (Item item : itemsList) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(UUID.randomUUID().toString());
                orderItem.setOrderid(newOrder.getId());
                orderItem.setVendorId(item.getVendorId());
                orderItem.setProductId(item.getProductId());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setItemPrice(item.getItemPrice());
                orderItemList.add(orderItem);

            }
            orderView.setOrderItems(orderItemList);
            orderViewList.add(orderView);
            return orderView;
        }
        catch(Exception e){
            throw new Exception();
        }

    }

    @Override
    public OrderView updateOrder(OrderDto order) throws Exception{
              OrderView orderView=new OrderView();
        try {
            //fetching the order and orderItem with given order id
            for (OrderView o:orderViewList) {
                if (o.getOrder().getId().equalsIgnoreCase(order.getOrderId())) {
                    //updating the order
                    o.getOrder().setOrderStatus("UPDATED");
                    o.getOrder().setUpdatedDate(new Date());
                    orderView.setOrder(o.getOrder());
                    o.getOrderItems().clear();
                    List<Item> itemsList = order.getItemList();
                    for (Item item : itemsList) {
                        OrderItem orderItem = new OrderItem();
                        orderItem.setId(UUID.randomUUID().toString());
                        orderItem.setOrderid(o.getOrder().getId());
                        orderItem.setVendorId(item.getVendorId());
                        orderItem.setProductId(item.getProductId());
                        orderItem.setQuantity(item.getQuantity());
                        orderItem.setItemPrice(item.getItemPrice());
                        o.getOrderItems().add(orderItem);
                    }
                    orderView.setOrderItems(o.getOrderItems());

                }
            }
            orderViewList.add(orderView);
            return orderView;
        }
        catch(Exception e){
          throw new Exception();
        }

    }

    @Override
    public void deleteOrder(String orderId) throws Exception {
        try{
            for(OrderView o:orderViewList){
                if(orderId.equalsIgnoreCase(o.getOrder().getId())){
                    orderViewList.remove(o);
                    if(orderViewList.size()<1){
                        break;
                    }

                }
            }
        }
        catch(Exception e){
            throw new Exception();
        }
    }

    @Override
    public OrderView getOrders(String orderId) throws Exception {

        OrderView orderView=new OrderView();
        try{
            for(OrderView o:orderViewList){
                if(orderId.equalsIgnoreCase(o.getOrder().getId())){
                   orderView.setOrder(o.getOrder());
                   orderView.setOrderItems(o.getOrderItems());
                }
            }
            return orderView;
        }
        catch(Exception e){
            throw new Exception();
        }
    }
}
