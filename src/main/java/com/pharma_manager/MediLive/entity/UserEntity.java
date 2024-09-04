package com.pharma_manager.MediLive.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @SequenceGenerator(name="my_seq", sequenceName="user_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "my_seq")
    private Long userId;

    @NonNull
    @Column(name = "username")
    private String userName;

    @NonNull
    @Column(name = "password")
    private String passWord;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "roles", columnDefinition = "TEXT[]")
    private String[] roles;
}
