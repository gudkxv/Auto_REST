package com.example.auto_rest.Controller;

import com.example.auto_rest.Entity.RepairData;
import com.example.auto_rest.Service.RepairDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepairDataController {
    private RepairDataService repairDataService;
    public RepairDataController(RepairDataService repairDataService){
        this.repairDataService = repairDataService;
    }

    public ResponseEntity<?> createData(@RequestBody RepairData repairData){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
