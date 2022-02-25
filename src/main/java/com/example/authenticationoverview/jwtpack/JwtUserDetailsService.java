package com.example.authenticationoverview.jwtpack;

import com.example.authenticationoverview.dao.AuthData;
import com.example.authenticationoverview.dao.AuthDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthDataRepo authDataRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthData authData = authDataRepo.findByUsername(username);
        System.out.println("authData:"+authData);
        if (authData!= null) {
            Collection<String> mappedAuthorities = Arrays.asList(authData.getRole().split(","));
            User user = new User(username, new BCryptPasswordEncoder().encode(authData.getPassword()), mappedAuthorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
            return user;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}