package com.example.auto_rest.Controller;

import com.example.auto_rest.Entity.MechanicData;
import com.example.auto_rest.Service.MechanicDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MechanicDataController {
    private MechanicDataService mechanicDataService;

    public MechanicDataController(MechanicDataService mechanicDataService) {
        this.mechanicDataService = mechanicDataService;
    }

    @GetMapping("/mechanics")
    public ResponseEntity<List<MechanicData>> getMechanics() {
        List<MechanicData> mechanics = mechanicDataService.getAll();
        return mechanics != null && !mechanics.isEmpty()
                ? new ResponseEntity<>(mechanics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mechanics/filter")
    public ResponseEntity<List<MechanicData>> getMechanicsByFilter(@RequestParam(required = false,defaultValue = ".*") String name,
                                                                   @RequestParam(required = false,defaultValue = ".*") String surname,
                                                                   @RequestParam(required = false,defaultValue = ".*") String specialisation) {
        List<MechanicData> mechanics = mechanicDataService.getDataByQuery(name,surname,specialisation);
        return mechanics != null && !mechanics.isEmpty()
                ? new ResponseEntity<>(mechanics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mechanics/{id}")
    public ResponseEntity<MechanicData> getMechanics(@PathVariable("id") Long id) {

        Optional<MechanicData> mechanicData = mechanicDataService.getById(id);
        return mechanicData.isPresent()
                ? new ResponseEntity<>(mechanicData.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/mechanics/add")
    public ResponseEntity<?> createData(@RequestBody MechanicData mechanicData) {
        mechanicDataService.addMechanicData(mechanicData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/mechanics/delete/{id}")
    public ResponseEntity<?> removeMechanic(@PathVariable("id") Long id) {
        mechanicDataService.removeMechanicDataById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
