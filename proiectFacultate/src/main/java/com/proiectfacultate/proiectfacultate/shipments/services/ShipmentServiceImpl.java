package com.proiectfacultate.proiectfacultate.shipments.services;

import com.proiectfacultate.proiectfacultate.shipments.model.Shipment;
import com.proiectfacultate.proiectfacultate.shipments.repositories.ShipmentRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    ShipmentRepositoryJPA shipmentRepositoryJPA;

    public ShipmentServiceImpl(ShipmentRepositoryJPA shipmentRepositoryJPA) {
        this.shipmentRepositoryJPA = shipmentRepositoryJPA;
    }

}
