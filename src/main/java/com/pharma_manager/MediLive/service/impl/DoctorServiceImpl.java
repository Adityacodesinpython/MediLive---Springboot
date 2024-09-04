package com.pharma_manager.MediLive.service.impl;

import com.pharma_manager.MediLive.dto.DoctorDto;
import com.pharma_manager.MediLive.entity.DoctorEntity;
import com.pharma_manager.MediLive.exception.ResourceNotFoundException;
import com.pharma_manager.MediLive.mapper.DoctorMapper;
import com.pharma_manager.MediLive.repository.DoctorRepository;
import com.pharma_manager.MediLive.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service    // creates a bean/instance of the service to use
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    public DoctorRepository doctorRepository;

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        DoctorEntity doctorEntity = DoctorMapper.mapToDoctorEntity(doctorDto);
        doctorRepository.save(doctorEntity);

        return DoctorMapper.mapToDoctorDto(doctorEntity);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<DoctorEntity> allDoctorsEntity = doctorRepository.findAll();
        return allDoctorsEntity.stream().map((oneDoctorEntity) -> DoctorMapper.mapToDoctorDto(oneDoctorEntity))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {

        DoctorEntity foundDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no doctor with the ID: " + doctorId));

        return DoctorMapper.mapToDoctorDto(foundDoctor);

    }

    @Override
    public DoctorDto updateDoctor(Long doctorId, DoctorDto updateDoctorInfo) {

        DoctorEntity foundDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no doctor with the ID: " + doctorId));

        foundDoctor.setName(updateDoctorInfo.getName());
        foundDoctor.setDepartment(updateDoctorInfo.getDepartment());
        foundDoctor.setIsAvailable(updateDoctorInfo.getIsAvailable());
        foundDoctor.setInAnEmergency(updateDoctorInfo.getInAnEmergency());

        DoctorEntity updatedDoctor = doctorRepository.save(foundDoctor);
        return DoctorMapper.mapToDoctorDto(updatedDoctor);

    }

    @Override
    public void deleteDoctor(Long doctorId) {
        DoctorEntity foundDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no doctor with the ID: " + doctorId));

        doctorRepository.deleteById(doctorId);
    }


}
