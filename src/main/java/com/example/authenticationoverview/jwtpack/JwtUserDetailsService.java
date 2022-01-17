package com.example.authenticationoverview.jwtpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.example.authenticationoverview.dao.AuthData;
import com.example.authenticationoverview.dao.AuthDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthDataRepo authDataRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

/*    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("javainuse".equals(username)) {
//            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());// with password - password
            return new User("javainuse", "Ankitha",
                    new ArrayList<>());// with password - Ankitha
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthData authData = authDataRepo.findByUsername(username);
        System.out.println("authData:"+authData);
        if (authData!= null) {
            Collection<String> mappedAuthorities = Arrays.asList(authData.getRole().split(","));
//            User user = new User(username, new BCryptPasswordEncoder().encode(authData.getPassword()), Arrays.asList(() -> authData.getRole()));
            User user = new User(username, new BCryptPasswordEncoder().encode(authData.getPassword()), mappedAuthorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
//            System.out.println("usr="+user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
            return user;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}