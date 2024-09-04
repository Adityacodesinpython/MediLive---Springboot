package com.pharma_manager.MediLive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class NurseEntity {
    @NonNull
    private String nurseId;
    @NonNull
    private String name;

    private String isAvailable;

}
