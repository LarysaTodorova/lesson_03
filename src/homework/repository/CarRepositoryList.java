package homework.repository;

import homework.entity.Car;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryList implements CarRepository {

   private   List<Car> dataBase = new ArrayList<>();

    public CarRepositoryList(List<Car> dataBase) {
       initData();
    }

    @Override
    public Car getCarById(Long id) {
        return dataBase.get(Math.toIntExact(id));
    }

    private void initData() {
        dataBase.add(new Car(1L, "Audi", new BigDecimal(2024)));
        dataBase.add(new Car(2L, "BMW", new BigDecimal(2019)));
        dataBase.add(new Car(3L, "Honda", new BigDecimal(3)));
    }
}
