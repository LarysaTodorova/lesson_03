package homework.service;

import homework.entity.Car;

import java.util.Optional;

public interface CarService {

    Optional<Car> getById(Long id);

}
