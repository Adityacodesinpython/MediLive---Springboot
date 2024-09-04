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
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    @SequenceGenerator(name="my_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "my_seq")
    private Long doctorId;

    @NonNull
    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "isAvailable")
    private String isAvailable;

    @Column(name = "inAnEmergency")
    private String inAnEmergency;

}
