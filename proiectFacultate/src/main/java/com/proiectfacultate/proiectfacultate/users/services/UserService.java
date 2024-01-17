package com.proiectfacultate.proiectfacultate.users.services;

import com.proiectfacultate.proiectfacultate.common.requestModel.SignUpModel;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;
import com.proiectfacultate.proiectfacultate.users.model.UserResponse;

import java.util.List;

public interface UserService {
    User createUser(SignUpModel signUpModel);

    UserResponse login(User user);

    List<Order> getOrdersByUserName(String token, String userName);

    User changeUserName(String token, String userName, String newUserName);

    boolean deleteUser(String token, String userName);

}
