package com.restfullapi.rest_full.apis;

import com.restfullapi.rest_full.containts.Message;
import com.restfullapi.rest_full.exceptions.PasswordIncorrectException;
import com.restfullapi.rest_full.requests.LoginRequest;
import com.restfullapi.rest_full.requests.RegisterRequest;
import com.restfullapi.rest_full.services.auth.AuthService;
import com.restfullapi.rest_full.ultis.ApiResponseHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/public/auth")
public class AuthApi {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            return ApiResponseHelper.gI().resp(authService.login(loginRequest), HttpStatus.OK, Message.DEFAULT_SUCCESS_MESSAGE);
        } catch (Exception e) {
            if (e instanceof PasswordIncorrectException) {
                return ApiResponseHelper.gI().resp(null, HttpStatus.BAD_REQUEST, Message.PASSWORD_INCORRECT);
            }
            if (e instanceof UsernameNotFoundException) {
                return ApiResponseHelper.gI().resp(null, HttpStatus.BAD_REQUEST, Message.USER_NOT_FOUND);
            }
            return ApiResponseHelper.gI().fallback(e);
        }
    }

    @GetMapping("/index")
    public String demo() {
        return "hello";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody(required = true) RegisterRequest registerRequest) {
        try {
            return ApiResponseHelper.gI().resp(authService.register(registerRequest), HttpStatus.OK, Message.DEFAULT_SUCCESS_MESSAGE);
        } catch (Exception e) {
            return ApiResponseHelper.gI().fallback(e);
        }
    }
}
