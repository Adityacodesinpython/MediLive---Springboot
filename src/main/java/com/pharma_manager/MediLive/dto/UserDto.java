package com.pharma_manager.MediLive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;

    private String userName;

    private String passWord;

    private String firstName;

    private String lastName;

    private String[] roles;
}
