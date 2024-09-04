package com.pharma_manager.MediLive.mapper;

import com.pharma_manager.MediLive.dto.DoctorDto;
import com.pharma_manager.MediLive.entity.DoctorEntity;

public class DoctorMapper {
    // static as object creation isn't required
    public static DoctorDto mapToDoctorDto(DoctorEntity doctorEntity) {
        return new DoctorDto(
                doctorEntity.getDoctorId(),
                doctorEntity.getName(),
                doctorEntity.getDepartment(),
                doctorEntity.getIsAvailable(),
                doctorEntity.getInAnEmergency()
        );
    }

    public static DoctorEntity mapToDoctorEntity(DoctorDto doctorDto) {
        return new DoctorEntity(
                doctorDto.getDoctorId(),
                doctorDto.getName(),
                doctorDto.getDepartment(),
                doctorDto.getIsAvailable(),
                doctorDto.getInAnEmergency()
        );
    }
}
