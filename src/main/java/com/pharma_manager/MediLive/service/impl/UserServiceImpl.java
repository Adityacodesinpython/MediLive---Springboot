package com.pharma_manager.MediLive.service.impl;

import com.pharma_manager.MediLive.dto.UserDto;
import com.pharma_manager.MediLive.entity.UserEntity;
import com.pharma_manager.MediLive.exception.ResourceNotFoundException;
import com.pharma_manager.MediLive.mapper.UserMapper;
import com.pharma_manager.MediLive.repository.UserRepository;
import com.pharma_manager.MediLive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service    // creates a bean/instance of the service to use
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // authenticated/hashed method
    @Override
    public UserDto saveNewUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto);
        userEntity.setPassWord(passwordEncoder.encode(userEntity.getPassWord()));
        userEntity.setRoles(new String[]{"USER"});
        userRepository.save(userEntity);

        return UserMapper.mapToUserDto(userEntity);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto);
        userRepository.save(userEntity);

        return UserMapper.mapToUserDto(userEntity);
    }

    public UserDto findByUserName(String userName) {
        return UserMapper.mapToUserDto(userRepository.findByUserName(userName));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> allUsersEntity = userRepository.findAll();
        return allUsersEntity.stream().map((oneUserEntity) -> UserMapper.mapToUserDto(oneUserEntity))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long userId) {

        UserEntity foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no user with the ID: " + userId));

        return UserMapper.mapToUserDto(foundUser);

    }

    @Override
    public UserDto updateUser(String userName, UserDto updateUserInfo) {

        UserEntity foundUser = userRepository.findByUserName(userName);
        foundUser.setUserName(updateUserInfo.getUserName());
        foundUser.setPassWord(passwordEncoder.encode(foundUser.getPassWord()));
        foundUser.setFirstName(updateUserInfo.getFirstName());
        foundUser.setLastName(updateUserInfo.getLastName());
        foundUser.setRoles(updateUserInfo.getRoles());

        UserEntity updatedUser = userRepository.save(foundUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no user with the ID: " + userId));

        userRepository.deleteById(userId);
    }


}
