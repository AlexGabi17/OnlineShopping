package com.proiectfacultate.proiectfacultate.users.controllers;

import com.proiectfacultate.proiectfacultate.common.requestModel.SignUpModel;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;
import com.proiectfacultate.proiectfacultate.users.model.UserResponse;
import com.proiectfacultate.proiectfacultate.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class Users {
    UserService userService;

    public Users(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> signUp(@RequestBody SignUpModel signUpModel){
        return ResponseEntity.ok(userService.createUser(signUpModel));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody User user){
        return ResponseEntity.ok(userService.login(user));
    }

    @GetMapping("/getOrdersByUserName")
    public ResponseEntity< List<Order> > getOrdersByUserName(@RequestHeader(name = "userToken") String token, @RequestParam(name = "userName") String userName){
        return ResponseEntity.ok(userService.getOrdersByUserName(token, userName));
    }

    @PutMapping("/change")
    public ResponseEntity<User> getUserInfo(@RequestHeader(name = "userToken") String token, @RequestParam String userName, @RequestParam String newUserName){
        return ResponseEntity.ok(userService.changeUserName(token, userName, newUserName));
    }

    @DeleteMapping("delete")
    public ResponseEntity<Map<String,String>> getUserInfo(@RequestHeader(name = "userToken") String token, @RequestParam String userName){
        if (userService.deleteUser(token, userName)){
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "The user was succesfully removed.");
            return ResponseEntity.ok(response);
        }
        else{
            Map<String, String> response = new HashMap<>();
            response.put("status", "failed");
            response.put("message", "User not found or an error occurred during deletion.");
            return ResponseEntity.ok(response);
        }
    }


}
