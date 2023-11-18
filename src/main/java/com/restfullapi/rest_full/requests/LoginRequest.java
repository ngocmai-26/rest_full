package com.restfullapi.rest_full.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
