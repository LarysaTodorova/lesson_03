package homework.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {

    private Long id;
    private String producer;
    private BigDecimal price;
    private String model;

    public Car(Long id, String producer, BigDecimal price) {
        this.id = id;
        this.producer = producer;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car car)) return false;
        return Objects.equals(id, car.id) && Objects.equals(producer, car.producer) && Objects.equals(price, car.price) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producer, price, model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                '}';
    }
}
