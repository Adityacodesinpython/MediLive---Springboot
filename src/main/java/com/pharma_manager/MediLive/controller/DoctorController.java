package com.pharma_manager.MediLive.controller;

import com.pharma_manager.MediLive.dto.DoctorDto;
import com.pharma_manager.MediLive.entity.DoctorEntity;
import com.pharma_manager.MediLive.exception.ResourceNotFoundException;
import com.pharma_manager.MediLive.mapper.DoctorMapper;
import com.pharma_manager.MediLive.service.DoctorService;
import com.pharma_manager.MediLive.service.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    public DoctorService doctorService;

    @GetMapping()
    public ResponseEntity<List<DoctorDto>> getALlDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DoctorDto> getSpecificDoctor(@PathVariable("id") Long doctorId) {
        return new ResponseEntity<>(doctorService.getDoctorById(doctorId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto savedDoctorDto = doctorService.createDoctor(doctorDto);

        return new ResponseEntity<>(savedDoctorDto, HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("id") Long doctorId, @RequestBody DoctorDto doctorInfo) {
        System.out.println(doctorInfo);
        return new ResponseEntity<>(doctorService.updateDoctor(doctorId, doctorInfo), HttpStatus.OK);

    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long doctorId) {
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor deleted successfully.", HttpStatus.OK);
    }


}
