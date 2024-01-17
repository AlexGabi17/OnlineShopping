package com.proiectfacultate.proiectfacultate.orders.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proiectfacultate.proiectfacultate.items.model.Item;
import com.proiectfacultate.proiectfacultate.shipments.model.Shipment;
import com.proiectfacultate.proiectfacultate.users.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long orderId;

    @NotNull
    @Column(name = "orderDate")
    private LocalDateTime orderDate;


    @Column(name = "comments")
    private String comments;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<Item> items;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Shipment shipment;

//    @OneToMany(targetEntity = Item.class)
//    private List<Item> items;

    public Order() {

    }

    public Order(Long orderId, LocalDateTime orderDate, String comments, User user, List<Item> items, Shipment shipment) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.comments = comments;
        this.user = user;
        this.items = items;
        this.shipment = shipment;
    }


    public Long getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(comments, order.comments) && Objects.equals(user, order.user) && Objects.equals(items, order.items) && Objects.equals(shipment, order.shipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, comments, user, items, shipment);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", comments='" + comments + '\'' +
                ", items=" + items +
                ", shipment=" + shipment +
                '}';
    }
}
