package com.proiectfacultate.proiectfacultate.orders.repositories;

import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Qualifier(value = "jpa")
@Primary
@Repository
public interface OrderRepositoryJPA extends JpaRepository<Order, Long> {
//    void deleteByOrderId(Long orderId);
    Order findByOrderId(Long orderId);
}
