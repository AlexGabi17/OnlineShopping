package com.proiectfacultate.proiectfacultate.orders.controllers;

import com.proiectfacultate.proiectfacultate.common.requestModel.PlaceOrder;
import com.proiectfacultate.proiectfacultate.items.model.Item;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.orders.services.OrderService;
import com.proiectfacultate.proiectfacultate.users.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class Orders {
    OrderService orderService;

    public Orders(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeorder")
    public ResponseEntity<Order> placeOrder(@RequestHeader(name = "userToken") String token, @RequestBody PlaceOrder parameters){
        return ResponseEntity.ok(orderService.placeOrder(token, parameters.getUserName(), parameters.getComments(), parameters.getItemIds(), parameters.getShipmentCompanyName()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, String>> deleteOrder(@RequestHeader(name = "userToken") String token, @RequestParam Long orderId){
        if (orderService.deleteOrder(token, orderId)){
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "The order was succesfully removed.");
            return ResponseEntity.ok(response);
        }
        else{
            Map<String, String> response = new HashMap<>();
            response.put("status", "failed");
            response.put("message", "Order not found or an error occurred during deletion.");
            return ResponseEntity.ok(response);
        }
    }
    @PutMapping("/changeComments")
    public ResponseEntity<Order> changeComments(@RequestHeader(name = "userToken") String token, @RequestParam Long orderId, @RequestParam String newComment){
        return ResponseEntity.ok(orderService.changeComments(token, orderId, newComment));
    }

//    @PostMapping("/placeOrder")
//    public ResponseEntity<Order> placeOrder(@RequestBody Order order){
//        return ResponseEntity.ok(orderService.createOrder(order));
//    }
}
