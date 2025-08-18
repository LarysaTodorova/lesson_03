package homework.repository;

import homework.entity.Car;

import java.util.Optional;


public interface CarRepository {

  Optional<Car> getCarById(Long id);
}
