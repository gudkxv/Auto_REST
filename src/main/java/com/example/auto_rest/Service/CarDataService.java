package com.example.auto_rest.Service;

import com.example.auto_rest.Entity.CarData;
import com.example.auto_rest.Repository.CarDataRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarDataService {
    private CarDataRepository carDataRepository;
    public CarDataService(CarDataRepository carDataRepository){
        this.carDataRepository = carDataRepository;
    }

    public void addCarData(CarData carData){
        carDataRepository.save(carData);
    }

    public Optional<CarData> getById(Long id){
        return carDataRepository.findById(id);
    }
}

