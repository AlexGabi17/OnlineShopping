package com.proiectfacultate.proiectfacultate.shipments.controllers;

import com.proiectfacultate.proiectfacultate.items.model.Item;
import com.proiectfacultate.proiectfacultate.orders.services.OrderService;
import com.proiectfacultate.proiectfacultate.shipments.model.Shipment;
import com.proiectfacultate.proiectfacultate.shipments.services.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")

public class Shipments {
    ShipmentService shipmentService;

    public Shipments(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
}
