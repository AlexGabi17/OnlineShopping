package com.proiectfacultate.proiectfacultate.users.repositories;

import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);

    User getUser(String userName);
    User getUserById(Long userId);

}
