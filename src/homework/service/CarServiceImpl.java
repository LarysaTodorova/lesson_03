package homework.service;

import homework.entity.Car;
import homework.repository.CarRepositoryList;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    private CarRepositoryList repository;

    public CarServiceImpl(CarRepositoryList repository) {
        this.repository = repository;
    }

    @Override
    public Car getById(Long id) {
        return repository.getCarById(id);
    }
}
