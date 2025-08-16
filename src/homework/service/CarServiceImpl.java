package homework.service;

import homework.entity.Car;
import homework.repository.CarRepositoryList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

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
    public Car getById(Long id) {
        Car car = repository.getCarById(id);
        if (car != null) {
            setArticle(car);
        }
        return car;
    }

    private void setArticle(Car car) {
        String article = String.format("%s-%s-%d", carArticlePrefix, car.getProducer().charAt(0), car.getId());
        car.setArticle(article);
    }
}
