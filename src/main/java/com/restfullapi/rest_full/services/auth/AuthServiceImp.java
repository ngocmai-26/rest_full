package com.restfullapi.rest_full.services.auth;

import com.restfullapi.rest_full.configs.JWTTokenProvider;
import com.restfullapi.rest_full.enums.Roles;
import com.restfullapi.rest_full.exceptions.PasswordIncorrectException;
import com.restfullapi.rest_full.models.*;
import com.restfullapi.rest_full.repositories.AccountRepository;
import com.restfullapi.rest_full.repositories.RoleRepository;
import com.restfullapi.rest_full.repositories.UserRepository;
import com.restfullapi.rest_full.requests.LoginRequest;
import com.restfullapi.rest_full.requests.RegisterRequest;
import com.restfullapi.rest_full.responses.AccountResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {
    //day la phan xu ly chinh cua app trong folder services

    private final JWTTokenProvider jwtTokenProvider;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AccountResponse register(RegisterRequest registerRequest) throws Exception {
        Account account = new Account();
        Role role = roleRepository.findByRoleName(String.valueOf(Roles.USER));
        User user = new User();

        user.setPhone(registerRequest.getPhone());
        user.setEmail(registerRequest.getEmail());
        user.setFullName(registerRequest.getFullName());
        userRepository.save(user);

        account.setUsername(registerRequest.getUsername());
        account.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
        account.setRole(role);
        account.setUser(user);

        accountRepository.save(account);
        return new ModelMapper().map(account, AccountResponse.class);
    }

    @Override
    public AccountResponse login(LoginRequest loginRequest) throws Exception {
        Account account = accountRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("No user found"));
        if (new BCryptPasswordEncoder().matches(loginRequest.getPassword(), account.getPassword())) {
            AccountResponse accountResponse = new ModelMapper().map(account, AccountResponse.class);
            String token = jwtTokenProvider.generateTokenFromUsername(loginRequest.getUsername());
            accountResponse.setToken(token);
            return accountResponse;
        } else {
            throw new PasswordIncorrectException("Password incorrect!");
        }
    }
}
