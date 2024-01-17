package com.proiectfacultate.proiectfacultate.users.model;

import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.paymentMethods.model.PaymentMethod;
import com.proiectfacultate.proiectfacultate.shipments.model.Shipment;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "userName", unique = true)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;



    @OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Order> orders;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PaymentMethod paymentMethod;

    public User() {
    }

    public User(Long id, String userName, String password, String role, List<Order> orders, PaymentMethod paymentMethod) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.orders = orders;
        this.paymentMethod = paymentMethod;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(role, user.role) && Objects.equals(orders, user.orders) && Objects.equals(paymentMethod, user.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, role, orders, paymentMethod);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", orders=" + orders +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}

