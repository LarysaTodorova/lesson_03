package homework.client;

import homework.controller.CarController;
import homework.entity.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Optional;

public class CarApp {

    public static void main(String[] args) {


        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext("homework");

        CarController controller = context.getBean(CarController.class);

       Optional<Car> car = controller.getById(2L);

        System.out.println(car);
    }
}
