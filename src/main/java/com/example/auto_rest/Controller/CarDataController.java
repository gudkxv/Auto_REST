package com.example.auto_rest.Controller;

import com.example.auto_rest.Service.CarDataService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarDataController {
    private CarDataService carDataService;
    public CarDataController(CarDataService carDataService){
        this.carDataService = carDataService;
    }

}
