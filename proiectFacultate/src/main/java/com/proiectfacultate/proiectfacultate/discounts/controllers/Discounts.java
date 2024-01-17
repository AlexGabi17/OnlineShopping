package com.proiectfacultate.proiectfacultate.discounts.controllers;

import com.proiectfacultate.proiectfacultate.common.requestModel.DiscountModel;
import com.proiectfacultate.proiectfacultate.common.requestModel.PlaceOrder;
import com.proiectfacultate.proiectfacultate.discounts.model.Discount;
import com.proiectfacultate.proiectfacultate.discounts.services.DiscountService;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discounts")
public class Discounts {
    DiscountService discountService;

    public Discounts(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/createDiscount")
    public ResponseEntity<Discount> createDiscount(@RequestHeader(name = "userToken") String token, @RequestBody DiscountModel parameters){
        return ResponseEntity.ok(discountService.createDiscount(parameters));
    }

}
