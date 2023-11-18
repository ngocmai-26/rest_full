package com.restfullapi.rest_full.responses;

import com.restfullapi.rest_full.models.Role;
import com.restfullapi.rest_full.models.User;
import lombok.Data;

@Data
public class AccountResponse {
    private String token;
    private String username;
    private UserResponse user;
    private Role role;
}
