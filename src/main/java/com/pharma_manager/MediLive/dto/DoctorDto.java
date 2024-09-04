package com.pharma_manager.MediLive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long doctorId;

    private String name;

    private String department;

    private String isAvailable;

    private String inAnEmergency;
}
