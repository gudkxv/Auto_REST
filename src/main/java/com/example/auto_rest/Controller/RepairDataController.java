package com.example.auto_rest.Controller;

import com.example.auto_rest.Entity.CarData;
import com.example.auto_rest.Entity.MechanicData;
import com.example.auto_rest.Entity.RepairData;
import com.example.auto_rest.Repository.CarDataRepository;
import com.example.auto_rest.Repository.MechanicDataRepository;
import com.example.auto_rest.Service.RepairDataService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class RepairDataController {
    private final RepairDataService repairDataService;
    private final CarDataRepository carDataRepository;

    private final MechanicDataRepository mechanicDataRepository;

    public RepairDataController(RepairDataService repairDataService,
                                CarDataRepository carDataRepository,
                                MechanicDataRepository mechanicDataRepository) {
        this.repairDataService = repairDataService;
        this.carDataRepository = carDataRepository;
        this.mechanicDataRepository = mechanicDataRepository;
    }

    @PostMapping("/repair_info/add")
    public ResponseEntity<?> createData(@RequestBody RepairData repairData) {
        repairDataService.addData(repairData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/repair_info/link")
    public ResponseEntity<?> createLinkedData(@RequestBody RepairData repairData) {
        Optional<MechanicData> mechanic = mechanicDataRepository.findById(repairData.getMechanic().getId());
        if(mechanic.isPresent()){
            repairData.setMechanic(mechanic.get());
        } else {
            return new ResponseEntity<>("Mechanic is not found",HttpStatus.NOT_FOUND);
        }
        Optional<CarData> car = carDataRepository.findById(repairData.getCar().getId());
        if(car.isPresent()){
            repairData.setCar(car.get());
        } else {
            return new ResponseEntity<>("Car is not found",HttpStatus.NOT_FOUND);
        }
        repairDataService.addData(repairData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/repair_info")
    public ResponseEntity<List<RepairData>> getRepairData() {
        List<RepairData> repairDataList = repairDataService.getAll();
        return repairDataList != null && !repairDataList.isEmpty()
                ? new ResponseEntity<>(repairDataList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/repair_info/after")
    public ResponseEntity<List<RepairData>> getRepairDataAfter(@RequestParam @JsonFormat(pattern="dd-MM-yyyy")LocalDate date) {
        List<RepairData> repairDataList = repairDataService.getRepairDataByDateAfter(date);
        return repairDataList != null && !repairDataList.isEmpty()
                ? new ResponseEntity<>(repairDataList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/repair_info/before")
    public ResponseEntity<List<RepairData>> getRepairDataBefore(@RequestParam @JsonFormat(pattern="dd-MM-yyyy")LocalDate date) {
        List<RepairData> repairDataList = repairDataService.getRepairDataByDateBefore(date);
        return repairDataList != null && !repairDataList.isEmpty()
                ? new ResponseEntity<>(repairDataList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/repair_info/between")
    public ResponseEntity<List<RepairData>> getRepairDataBetween(@RequestParam @JsonFormat(pattern="dd-MM-yyyy")LocalDate startDate,
                                                                 @RequestParam @JsonFormat(pattern="dd-MM-yyyy")LocalDate endDate) {
        List<RepairData> repairDataList = repairDataService.getRepairDataByDateBetween(startDate,endDate);
        return repairDataList != null && !repairDataList.isEmpty()
                ? new ResponseEntity<>(repairDataList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/repair_info/filter")
    public ResponseEntity<List<RepairData>> getRepairDataByCustomQuery(@RequestParam(required = false,defaultValue = ".*" ) String type,
                                                                       @RequestParam(required = false,defaultValue = ".*") String owner,
                                                                       @RequestParam(required = false,defaultValue = ".*") String model,
                                                                       @RequestParam(required = false,defaultValue = ".*") String firm,
                                                                       @RequestParam(required = false,defaultValue = ".*") String name,
                                                                       @RequestParam(required = false,defaultValue = ".*") String surname,
                                                                       @RequestParam(required = false,defaultValue = ".*") String specialisation) {
        List<RepairData> repairDataList = repairDataService.getRepairDataByCustomQuery(type, owner, model, firm, name, surname, specialisation);
        return repairDataList != null && !repairDataList.isEmpty()
                ? new ResponseEntity<>(repairDataList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
