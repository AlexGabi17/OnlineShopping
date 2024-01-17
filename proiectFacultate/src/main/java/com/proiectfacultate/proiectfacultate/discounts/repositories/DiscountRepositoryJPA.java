package com.proiectfacultate.proiectfacultate.discounts.repositories;


import com.proiectfacultate.proiectfacultate.discounts.model.Discount;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier(value = "jpa")
@Primary
@Repository
public interface DiscountRepositoryJPA extends JpaRepository<Discount, Long> {

    Discount findByDiscountId(Long discountId);

}
