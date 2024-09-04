package com.pharma_manager.MediLive.service;

import com.pharma_manager.MediLive.dto.DoctorDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(Long doctorId);

    DoctorDto updateDoctor(Long doctorId, DoctorDto updateDoctorInfo);

    void deleteDoctor(Long doctorId);
}
