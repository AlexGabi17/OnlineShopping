package com.proiectfacultate.proiectfacultate.discounts.services;

import com.proiectfacultate.proiectfacultate.common.requestModel.DiscountModel;
import com.proiectfacultate.proiectfacultate.discounts.model.Discount;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DiscountService {
    Discount createDiscount(DiscountModel discountModel);
}
