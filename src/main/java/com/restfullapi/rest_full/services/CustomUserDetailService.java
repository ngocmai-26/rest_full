package com.restfullapi.rest_full.services;

import com.restfullapi.rest_full.models.Account;
import com.restfullapi.rest_full.models.CustomUserDetail;
import com.restfullapi.rest_full.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Not found user account"));
        return CustomUserDetail.create(account);
    }
    public CustomUserDetail getById(Long id){
        Account account = accountRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("Not found user"));
        return CustomUserDetail.create(account);
    }
}
