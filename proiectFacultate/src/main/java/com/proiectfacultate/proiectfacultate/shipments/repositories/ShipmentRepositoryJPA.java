package com.proiectfacultate.proiectfacultate.shipments.repositories;

import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.shipments.model.Shipment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier(value = "jpa")
@Primary
@Repository
public interface ShipmentRepositoryJPA  extends JpaRepository<Order, Long> {
    Shipment findShipmentById(Long shipmentId);

}
