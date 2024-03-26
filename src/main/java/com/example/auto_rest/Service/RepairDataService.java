package com.example.auto_rest.Service;

import com.example.auto_rest.Entity.RepairData;
import com.example.auto_rest.Repository.RepairDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RepairDataService {
    final ObjectMapper mapper = new ObjectMapper();
    private final RepairDataRepository repairDataRepository;
    private final CarDataService carDataService;
    private final MechanicDataService mechanicDataService;

    public RepairDataService(RepairDataRepository repairDataRepository,
                             CarDataService carDataService,
                             MechanicDataService mechanicDataService) {
        this.repairDataRepository = repairDataRepository;
        this.carDataService = carDataService;
        this.mechanicDataService = mechanicDataService;
    }

    public void addData(RepairData data) {
        //CarData carInfo = mapper.readValue(data, CarData.class);
        repairDataRepository.save(data);
    }

    public List<RepairData> getRepairDataByCustomQuery(String type, String owner, String model, String firm, String name, String surname, String specialisation){
        return repairDataRepository.getRepairDataByKidsCustomQuery(type, owner, model, firm, name, surname, specialisation);
    }

    public List<RepairData> getRepairDataByDateBetween(LocalDate dateStart, LocalDate dateFinish){
        return repairDataRepository.getRepairDataByDateBetween(dateStart, dateFinish);
    }

    public List<RepairData> getRepairDataByDateAfter(LocalDate date){
        return repairDataRepository.getRepairDataByDateAfter(date);
    }

    public List<RepairData> getRepairDataByDateBefore(LocalDate date){
        return repairDataRepository.getRepairDataByDateBefore(date);
    }

    public List<RepairData> getAll() {
        return repairDataRepository.findAll();
    }
}
