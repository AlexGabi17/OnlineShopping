package com.proiectfacultate.proiectfacultate.orders.repositories;

import com.proiectfacultate.proiectfacultate.orders.model.Order;

import java.util.List;

public interface OrderRepository {

//    Order save(Order order);

    Order getOrder(Long orderId);
}
