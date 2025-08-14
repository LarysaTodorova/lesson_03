package homework.controller;

import homework.entity.Car;
import homework.service.CarServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class CarController {

    private CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    public Car getById(Long id) {
       return carService.getById(id);
    }
}
