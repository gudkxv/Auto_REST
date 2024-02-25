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
    public ResponseEntity<List<MechanicData>> getMechanics(){
        List<MechanicData> mechanics = mechanicDataService.getAll();
        return mechanics != null && !mechanics.isEmpty()
                ? new ResponseEntity<>(mechanics,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/mechanics/{id}")
    public ResponseEntity<MechanicData> getMechanics(@PathVariable("id") Long id){

        Optional<MechanicData> mechanicData = mechanicDataService.getById(id);
        return mechanicData.isPresent()
                ? new ResponseEntity<>(mechanicData.get(),HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/mechanic/add")
    public ResponseEntity<?> createData(@RequestBody MechanicData mechanicData){
        mechanicDataService.addMechanicData(mechanicData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
