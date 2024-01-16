package com.proiectfacultate.proiectfacultate.items.controllers;


import com.proiectfacultate.proiectfacultate.common.requestModel.ItemRequestModel;
import com.proiectfacultate.proiectfacultate.common.requestModel.PlaceOrder;
import com.proiectfacultate.proiectfacultate.items.model.Item;
import com.proiectfacultate.proiectfacultate.items.services.ItemService;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.orders.services.OrderService;
import com.proiectfacultate.proiectfacultate.users.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
public class Items {
    ItemService itemService;


    public Items(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestHeader(name = "userToken") String token, @RequestBody ItemRequestModel itemModel){
        return ResponseEntity.ok(itemService.addItem(itemModel));
    }
    @PutMapping("/changeName")
    public ResponseEntity<Item> changeName(@RequestHeader(name = "userToken") String token, @RequestParam Long itemId, @RequestParam String newName){
        return ResponseEntity.ok(itemService.changeName(token, itemId, newName));
    }

    @PutMapping("/changePrice")
    public ResponseEntity<Item> changePrice(@RequestHeader(name = "userToken") String token, @RequestParam Long itemId, @RequestParam int newPrice){
        return ResponseEntity.ok(itemService.changePrice(token, itemId, newPrice));
    }

    @PutMapping("/changeDescription")
    public ResponseEntity<Item> getDescription(@RequestHeader(name = "userToken") String token, @RequestParam Long itemId, @RequestParam String newDescription){
        return ResponseEntity.ok(itemService.changeDescription(token, itemId, newDescription));
    }

    @GetMapping("/getItem")
    public ResponseEntity<Item> getItemById(@RequestHeader(name = "userToken") String token, @RequestParam(name = "itemId") Long itemId){
        return ResponseEntity.ok(itemService.getItemById(token, itemId));
    }
}
