package com.example.authenticationoverview.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthDataRepo extends JpaRepository<AuthData, String> {
    AuthData findByUsername(String username);
}
