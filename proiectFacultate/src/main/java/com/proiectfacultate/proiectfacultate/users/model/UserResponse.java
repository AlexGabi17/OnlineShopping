package com.proiectfacultate.proiectfacultate.users.model;

import java.util.UUID;

public class UserResponse {
    String token;

    public UserResponse() {
        token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }
}
