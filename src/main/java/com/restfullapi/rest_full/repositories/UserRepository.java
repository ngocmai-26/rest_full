package com.restfullapi.rest_full.repositories;

import com.restfullapi.rest_full.models.Role;
import com.restfullapi.rest_full.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
}
