package com.proiectfacultate.proiectfacultate.items.repositories;

import com.proiectfacultate.proiectfacultate.items.model.Item;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier(value = "jpa")
@Primary
@Repository
public interface ItemRepositoryJPA extends JpaRepository<Item, Long> {

    Item findByItemId(Long itemId);

}
