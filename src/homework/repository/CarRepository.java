package homework.repository;

import homework.entity.Car;


public interface CarRepository {

    Car getCarById(Long id);
}
