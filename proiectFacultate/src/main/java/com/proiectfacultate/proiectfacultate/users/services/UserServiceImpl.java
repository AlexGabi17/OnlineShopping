package com.proiectfacultate.proiectfacultate.users.services;

import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;
import com.proiectfacultate.proiectfacultate.users.model.UserResponse;
import com.proiectfacultate.proiectfacultate.users.repositories.UserRepositoryImpl;
import com.proiectfacultate.proiectfacultate.users.repositories.UserRepositoryJPA;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepositoryJPA userRepository;

    public UserServiceImpl(@Qualifier(value = "jpa") UserRepositoryJPA userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserResponse login(User user) {
        User storedUser = userRepository.findByUserName(user.getUserName());
        if(user.getPassword().equals(storedUser.getPassword())){
            return new UserResponse();
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByUserName(String token, String userName) {
        verifyUser(token);
        User user = userRepository.findByUserName(userName);

        return user.getOrders();
    }

    @Override
    public User changeUserName(String token, String userName, String newUserName) {
        User user = userRepository.findByUserName(userName);
        user.setUserName(newUserName);

        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(String token, String userName) {
        User user = userRepository.findByUserName(userName);
        if(user != null){
            userRepository.delete(user);
            return true;
        }
        return false;

    }

    private static void verifyUser(String token) {
        if (token == null || Strings.isBlank(token)){
            throw new RuntimeException("User not logged in");
        }
    }

}
