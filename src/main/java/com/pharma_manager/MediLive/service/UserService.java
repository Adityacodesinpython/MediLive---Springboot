package com.pharma_manager.MediLive.service;

import com.pharma_manager.MediLive.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    UserDto updateUser(String username, UserDto updateUserInfo);

    void deleteUser(Long userId);

    UserDto saveNewUser(UserDto userDto);
}
