package com.project.ong_management.persistance.models;

import lombok.Data;

@Data
public class JWTRequest {

    private String username;
    private String password;
}
