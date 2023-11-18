package com.restfullapi.rest_full.repositories;

import com.restfullapi.rest_full.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    //day la repository lam viec voi db
    Optional<Account> findByUsername(String username);
}
