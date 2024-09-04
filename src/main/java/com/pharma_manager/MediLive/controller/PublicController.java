package com.pharma_manager.MediLive.controller;

import com.pharma_manager.MediLive.dto.UserDto;
import com.pharma_manager.MediLive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller for public/not-logged-in users
@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    public UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
//        UserDto savedUserDto = userService.createUser(userDto);
        UserDto savedUserDto = userService.saveNewUser(userDto);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }
}
