package com.proiectfacultate.proiectfacultate.orders.repositories;

import com.proiectfacultate.proiectfacultate.common.exceptions.DatabaseError;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;
import com.proiectfacultate.proiectfacultate.users.repositories.UserRepositoryJPA;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository

public class OrderRepositoryImpl implements OrderRepository{

    Set<Order> orders = new HashSet<>();
//    @Override
//    public Order save(Order order) {
//        orders.add(order);
//        return order;
//    }

    @Override
    public Order getOrder(Long orderId) {
        return orders.stream().filter(order -> order.getOrderId().equals(orderId)).findFirst().orElseThrow();
    }



    private void checkDatabase() {
        if (orders == null) throw new DatabaseError("Connection failed!");
    }




}
