package org.example.controller;

import org.example.dto.OrderDto;
import org.example.service.OrderService;
import org.example.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

   @PostMapping(value= "/order/create")
    public ResponseEntity<OrderView> createOrder(@RequestBody OrderDto order){
      try{
          OrderView orderView = orderService.createOrder(order);
          return new ResponseEntity<>(orderView,HttpStatus.OK);
      }
      catch(Exception e){
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }

   }

    @PutMapping(value= "/order/update")
    public ResponseEntity<OrderView> updateOrder(@RequestBody OrderDto order){
        try{
            OrderView orderView= orderService.updateOrder(order);
            return new ResponseEntity<>(orderView,HttpStatus.OK);

        }
        catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(value="order/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable("orderId") String orderId){

        try {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="order/{orderId}")
    public ResponseEntity<OrderView> getOrders(@PathVariable("orderId") String orderId){
       try{
           OrderView orderView=orderService.getOrders(orderId);
           return new ResponseEntity<>(orderView,HttpStatus.OK);
       }
       catch(Exception e){
           System.out.println(e);
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
