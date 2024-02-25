package com.example.auto_rest.Service;

import com.example.auto_rest.Entity.MechanicData;
import com.example.auto_rest.Repository.MechanicDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicDataService {
    private MechanicDataRepository mechanicDataRepository;

    public MechanicDataService(MechanicDataRepository mechanicDataRepository){
        this.mechanicDataRepository = mechanicDataRepository;
    }
    public void addMechanicData(MechanicData mechanicData){
        mechanicDataRepository.save(mechanicData);
    }

    public List<MechanicData> getAll(){
        return mechanicDataRepository.findAll();
    }

    public Optional<MechanicData> getById(Long id){
        return mechanicDataRepository.findById(id);
    }

}
