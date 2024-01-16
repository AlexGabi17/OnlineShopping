package com.proiectfacultate.proiectfacultate.users.repositories;

import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository{
    Set<User> users = new HashSet<>();
    int id = 0;

    @Override
    public User createUser(User user){
        users.add(user);
        return user;
    }

    @Override
    public User getUser(String userName) {
        return users.stream().filter(user -> user.getUserName().equals(userName)).findFirst().orElseThrow();
    }

    @Override
    public User getUserById(Long userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElseThrow();
    }


}
