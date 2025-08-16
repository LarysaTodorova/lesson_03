package homework.repository;

import homework.entity.Car;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryList implements CarRepository {

    private List<Car> dataBase = new ArrayList<>();

    public CarRepositoryList(List<Car> dataBase) {
        initData();
    }

    @Override
    public Car getCarById(Long id) {
        return dataBase.stream()
                .filter(carrentCar -> carrentCar.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private void initData() {
        dataBase.add(new Car(1L, "Audi", "A_6", new BigDecimal(2024)));
        dataBase.add(new Car(2L, "BMW", "M_5", new BigDecimal(2019)));
        dataBase.add(new Car(3L, "Honda", "CRV", new BigDecimal(30000)));
        dataBase.add(new Car(4L, "Tesla", "T_1", new BigDecimal(45000)));
    }
}
