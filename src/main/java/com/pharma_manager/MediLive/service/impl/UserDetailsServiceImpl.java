package com.pharma_manager.MediLive.service.impl;


import com.pharma_manager.MediLive.entity.UserEntity;
import com.pharma_manager.MediLive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// UserDetailsService class implementation for authentication using spring boot security
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userEntity.getUserName())
                    .password(userEntity.getPassWord())
                    .roles(userEntity.getRoles())
                    .build();

        }
        throw new UsernameNotFoundException("User not found with the username: " + username);
    }
}
