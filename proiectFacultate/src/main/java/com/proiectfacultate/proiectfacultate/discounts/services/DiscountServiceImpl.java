package com.proiectfacultate.proiectfacultate.discounts.services;


import com.proiectfacultate.proiectfacultate.common.requestModel.DiscountModel;
import com.proiectfacultate.proiectfacultate.discounts.model.Discount;
import com.proiectfacultate.proiectfacultate.discounts.repositories.DiscountRepositoryJPA;
import com.proiectfacultate.proiectfacultate.users.model.User;
import com.proiectfacultate.proiectfacultate.users.repositories.UserRepository;
import com.proiectfacultate.proiectfacultate.users.repositories.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Qualifier(value = "jpa")
@Primary
public class DiscountServiceImpl implements DiscountService{

    DiscountRepositoryJPA discountRepositoryJPA;
    UserRepositoryJPA userRepositoryJPA;

    public DiscountServiceImpl(DiscountRepositoryJPA discountRepositoryJPA, UserRepositoryJPA userRepositoryJPA) {
        this.discountRepositoryJPA = discountRepositoryJPA;
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @Override
    public Discount createDiscount(DiscountModel discountModel) {
        Discount discount = new Discount();
        discount.setName(discountModel.getName());
        discount.setDescription(discountModel.getDescription());
        discount.setPercentage(discountModel.getPercentage());
        discount.setValidFrom(LocalDateTime.now());
        discount.setValidTo(LocalDateTime.now().plusDays(7)); // HARDCODED 7 DAYS

        User user = userRepositoryJPA.findByUserName(discountModel.getUserName());

        discount.setUser(user);

        discountRepositoryJPA.save(discount);
        return discount;
    }
}
