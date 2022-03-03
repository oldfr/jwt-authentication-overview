package com.example.authenticationoverview.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepo extends JpaRepository<UserData, String> {
    UserData findByUsername(String username);
}
