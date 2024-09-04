package com.pharma_manager.MediLive.controller;

import com.pharma_manager.MediLive.dto.DoctorDto;
import com.pharma_manager.MediLive.dto.UserDto;
import com.pharma_manager.MediLive.entity.DoctorEntity;
import com.pharma_manager.MediLive.exception.ResourceNotFoundException;
import com.pharma_manager.MediLive.mapper.DoctorMapper;
import com.pharma_manager.MediLive.service.DoctorService;
import com.pharma_manager.MediLive.service.UserService;
import com.pharma_manager.MediLive.service.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public DoctorService doctorService;

    @Autowired
    public UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDto>> getALlUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userInfo) {

        // get username from SecurityContextHolder which stores authenticated username
        // after they are registered automatically via create endpoint

        //FIXME if i update the credentials with new username password and use that to make a request
        // to re update, it gives me forbidden
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        UserDto updatedUser = userService.updateUser(userName, userInfo);

//        Authentication newAuth = new UsernamePasswordAuthenticationToken(
//                updatedUser.getUserName(),
//                userInfo.getPassWord(), // plaintext password given by user
//                authentication.getAuthorities()  // Reuse the same authorities
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(newAuth);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/get-doctor/{department}")
    public DoctorDto getEmergencyDoctors(@PathVariable String department) {
        List<DoctorDto> doctorsInDeptNotInEmer = new ArrayList<>();
        Random rand = new Random();

        List<DoctorDto> listOfDoctors =  doctorService.getAllDoctors();

        for (DoctorDto doctor: listOfDoctors) {
            if (Objects.equals(doctor.getDepartment(), department) && !Objects.equals(doctor.getInAnEmergency(), "true")) {
                doctorsInDeptNotInEmer.add(doctor);
            }
        }

        for (DoctorDto doctor : doctorsInDeptNotInEmer) {
            if (Objects.equals(doctor.getIsAvailable(), "true")){

                DoctorDto updatedDoctor = new DoctorDto(doctor.getDoctorId(), doctor.getName(), doctor.getDepartment(), "false", "true");
                return doctorService.updateDoctor(doctor.getDoctorId(), updatedDoctor);
            }
        }

        try {
            DoctorDto randomDoctorInDept = doctorsInDeptNotInEmer.get(rand.nextInt(doctorsInDeptNotInEmer.size()));

            DoctorDto updatedDoctor = new DoctorDto(randomDoctorInDept.getDoctorId(), randomDoctorInDept.getName(), randomDoctorInDept.getDepartment(), "false", "true");
            return doctorService.updateDoctor(updatedDoctor.getDoctorId(), updatedDoctor);

        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("All the doctors r in an emergency");
        }
    }
}
