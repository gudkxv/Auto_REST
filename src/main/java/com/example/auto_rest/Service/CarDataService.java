package com.example.auto_rest.Service;

import com.example.auto_rest.Entity.CarData;
import com.example.auto_rest.Repository.CarDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarDataService {
    private final CarDataRepository carDataRepository;

    public CarDataService(CarDataRepository carDataRepository) {
        this.carDataRepository = carDataRepository;
    }

    public void addCarData(CarData carData) {
        carDataRepository.save(carData);
    }

    public Optional<CarData> getById(Long id) {
        return carDataRepository.findById(id);
    }

    public List<CarData> getAll() {
        return carDataRepository.findAll();
    }

    public void removeCarDataById(Long id) {
        carDataRepository.deleteById(id);
    }

    public List<CarData> getCarsWithQuery(String param1,String param2,String param3,String param4){return carDataRepository.getCarsByCustomQuery(param1, param2, param3, param4);}

}

