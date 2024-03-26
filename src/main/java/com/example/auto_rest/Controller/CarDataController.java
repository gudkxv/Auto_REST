package com.example.auto_rest.Controller;

import com.example.auto_rest.Entity.CarData;
import com.example.auto_rest.Service.CarDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarDataController {
    private final CarDataService carDataService;

    public CarDataController(CarDataService carDataService) {
        this.carDataService = carDataService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarData>> getCars() {
        List<CarData> carList = carDataService.getAll();
        return carList != null && !carList.isEmpty()
                ? new ResponseEntity<>(carList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarData> getCarByID(@PathVariable("id") Long id) {
        Optional<CarData> car = carDataService.getById(id);
        return car.isPresent()
                ? new ResponseEntity<>(car.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cars/filter")
    public ResponseEntity<List<CarData>> testRequest(@RequestParam(required = false,defaultValue = ".*") String type,
                                                     @RequestParam(required = false,defaultValue = ".*") String owner,
                                                     @RequestParam(required = false,defaultValue = ".*") String model,
                                                     @RequestParam(required = false,defaultValue = ".*") String firm) {
        List<CarData> foundCars = carDataService.getCarsWithQuery(type, owner, model,firm);
        return foundCars != null && !foundCars.isEmpty()
                ? new ResponseEntity<>(foundCars, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/cars/add")
    public ResponseEntity<?> addCarData(@RequestBody CarData carData) {
        carDataService.addCarData(carData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/cars/delete/{id}")
    public ResponseEntity<?> deleteCarData(@PathVariable("id") Long id) {
        carDataService.removeCarDataById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
