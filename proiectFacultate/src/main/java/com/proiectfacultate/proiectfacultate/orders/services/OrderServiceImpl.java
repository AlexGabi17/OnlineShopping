package com.proiectfacultate.proiectfacultate.orders.services;

import com.proiectfacultate.proiectfacultate.items.model.Item;
import com.proiectfacultate.proiectfacultate.items.repositories.ItemRepositoryJPA;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.orders.repositories.OrderRepository;
import com.proiectfacultate.proiectfacultate.orders.repositories.OrderRepositoryImpl;
import com.proiectfacultate.proiectfacultate.orders.repositories.OrderRepositoryJPA;
import com.proiectfacultate.proiectfacultate.shipments.model.Shipment;
import com.proiectfacultate.proiectfacultate.users.model.User;
import com.proiectfacultate.proiectfacultate.users.repositories.UserRepository;
import com.proiectfacultate.proiectfacultate.users.repositories.UserRepositoryJPA;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Qualifier(value = "jpa")
@Primary
public class OrderServiceImpl implements OrderService{


    OrderRepository orderRepository;
    OrderRepositoryJPA orderRepositoryJPA;
    UserRepositoryJPA userRepository;
    ItemRepositoryJPA itemRepositoryJPA;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderRepositoryJPA orderRepositoryJPA,
                            UserRepositoryJPA userRepository,
                            ItemRepositoryJPA itemRepositoryJPA) {
        this.orderRepository = orderRepository;
        this.orderRepositoryJPA = orderRepositoryJPA;
        this.userRepository = userRepository;
        this.itemRepositoryJPA = itemRepositoryJPA;
    }

    @Override
    public Order placeOrder(String token, String userName, String comments, List<Long> itemIds, String shipmentCompanyName) {
        verifyUser(token);
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setComments(comments);
        User user = userRepository.findByUserName(userName);

        order.setUser(user);
        user.getOrders().add(order);

        // add Item
        List<Item> items = new ArrayList<Item>();
        for(int i=0; i<itemIds.size(); i++) {
            items.add(itemRepositoryJPA.findByItemId(itemIds.get(i)));
        }
        order.setItems(items);

        //

        //add Shipment info

        Shipment shipment = new Shipment();
        shipment.setShipmentCompanyName(shipmentCompanyName);
        shipment.setShipmentDate(LocalDateTime.now().plusDays(3)); // HARDCODED 3 DAYS
        shipment.setOrder(order);
        order.setShipment(shipment);
        //

        userRepository.save(user);
        return order;
    }

    @Transactional
    @Override
    public Boolean deleteOrder(String token, Long orderId){
        Order order = orderRepositoryJPA.findByOrderId(orderId);
        if(order!=null){
            User user = userRepository.findById(order.getUser().getId());
            User newUser = user;

            List<Order> orders = newUser.getOrders();

            orders.remove(order);

            newUser.setOrders(orders);

            userRepository.save(newUser);

            return true;
        }

        return false;
    }

    @Override
    public Order changeComments(String token, Long orderId, String newComment) {
        Order order = orderRepositoryJPA.findByOrderId(orderId);
        order.setComments(newComment);
        return order;

    }


    private static void verifyUser(String token) {
        if (token == null || Strings.isBlank(token)){
            throw new RuntimeException("User not logged in");
        }
    }

}
