package com.restfullapi.rest_full.services.auth;

import com.restfullapi.rest_full.models.Account;
import com.restfullapi.rest_full.repositories.AccountRepository;
import com.restfullapi.rest_full.repositories.UserRepository;
import com.restfullapi.rest_full.requests.LoginRequest;
import com.restfullapi.rest_full.requests.RegisterRequest;
import com.restfullapi.rest_full.responses.AccountResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface AuthService {
    public AccountResponse register(RegisterRequest registerRequest) throws Exception;
    public AccountResponse login(LoginRequest loginRequest) throws Exception;
}
