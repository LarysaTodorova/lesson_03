package homework.service;

import homework.entity.Car;
import homework.repository.CarRepositoryList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@PropertySource("classpath:application.properties")
@Service
public class CarServiceImpl implements CarService {

    private CarRepositoryList repository;
    private String carArticlePrefix;

    public CarServiceImpl(CarRepositoryList repository, @Value("${carArticle.prefix}") String carArticlePrefix) {
        this.repository = repository;
        this.carArticlePrefix = carArticlePrefix;
    }

    @Override
    public Optional<Car> getById(Long id) {
        Optional<Car> optionalCar = repository.getCarById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            setArticle(car);
            return Optional.of(car);
        } else {
            throw new IllegalArgumentException("Entity with ID = " + id + " not found");
        }
    }

    private void setArticle(Car car) {
        String article = String.format("%s-%s-%d", carArticlePrefix, car.getProducer().charAt(0), car.getId());
        car.setArticle(article);
    }
}
