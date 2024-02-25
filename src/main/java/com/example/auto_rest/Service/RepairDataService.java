package com.example.auto_rest.Service;

import com.example.auto_rest.Repository.RepairDataRepository;
import org.springframework.stereotype.Service;

@Service
public class RepairDataService {
    private RepairDataRepository repairDataRepository;
    public RepairDataService(RepairDataRepository repairDataRepository){
        this.repairDataRepository = repairDataRepository;
    }
}
