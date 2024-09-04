package com.pharma_manager.MediLive.controller;

import com.pharma_manager.MediLive.entity.NurseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    private List<NurseEntity> listOfNurses = new ArrayList<>();

    @GetMapping()
    public List<NurseEntity> getALlNurses() {
        return listOfNurses;
    }

    @PostMapping()
    public boolean createNurse(@RequestBody NurseEntity nurseInfo) {

        listOfNurses.add(nurseInfo);
        return true;
    }

    @PutMapping("/id/{id}")
    public boolean updateNurse(@PathVariable String id, @RequestBody NurseEntity nurseInfo) {
        for (NurseEntity nurse: listOfNurses) {
            if (Objects.equals(nurse.getNurseId(), id)){
                nurse.setName(nurseInfo.getName());
                nurse.setIsAvailable(nurseInfo.getIsAvailable());
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteNurse(@PathVariable String id) {
        for (NurseEntity nurse: listOfNurses) {
            if (Objects.equals(nurse.getNurseId(), id)){
                listOfNurses.remove(nurse);
                return true;
            }
        }
        return false;
    }

    @GetMapping("/get-nurse")
    public NurseEntity getFreeNurses() {

        for (NurseEntity nurse: listOfNurses ) {
            if (Objects.equals(nurse.getIsAvailable(), "true")) {
                nurse.setIsAvailable("false");
                return nurse;
            }
        }
        // TODO - schedule a nurse for later if none available

        return null;
    }
}
