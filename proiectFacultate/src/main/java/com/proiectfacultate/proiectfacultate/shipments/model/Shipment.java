package com.proiectfacultate.proiectfacultate.shipments.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long shipmentId;

    @Column(name = "shipmentCompanyName")
    private String shipmentCompanyName;

    @Column(name = "shipmentDate")
    private LocalDateTime shipmentDate;


    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    @JsonIgnore
    private Order order;

    public Shipment() {

    }

    public Shipment(Long shipmentId, String shipmentCompanyName, LocalDateTime shipmentDate, Order order) {
        this.shipmentId = shipmentId;
        this.shipmentCompanyName = shipmentCompanyName;
        this.shipmentDate = shipmentDate;
        this.order = order;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentCompanyName() {
        return shipmentCompanyName;
    }

    public void setShipmentCompanyName(String shipmentCompanyName) {
        this.shipmentCompanyName = shipmentCompanyName;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDateTime getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDateTime shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return Objects.equals(shipmentId, shipment.shipmentId) && Objects.equals(shipmentCompanyName, shipment.shipmentCompanyName) && Objects.equals(shipmentDate, shipment.shipmentDate) && Objects.equals(order, shipment.order);
    }


    @Override
    public int hashCode() {
        return Objects.hash(shipmentId, shipmentCompanyName, shipmentDate, order);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", shipmentCompanyName='" + shipmentCompanyName + '\'' +
                ", shipmentDate=" + shipmentDate +
                '}';
    }
}
