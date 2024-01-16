package com.proiectfacultate.proiectfacultate.orders.services;

import com.proiectfacultate.proiectfacultate.items.model.Item;
import com.proiectfacultate.proiectfacultate.orders.model.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(String token, String userName, String comments, List<Long> itemIds);

    Boolean deleteOrder(String token, Long orderId);

}
