package hiber.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @EmbeddedId
    private CarId carId;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car(String model, int series) {
        CarId carId = new CarId(model, series);
        this.carId = carId;
    }

    public Car() {

    }

    public String getModel() {
        return carId.model;
    }

    public int getSeries() {
        return carId.series;
    }

    @Embeddable
    public static class CarId implements Serializable {
        @Column(name = "model")
        String model;

        @Column(name = "series")
        int series;

        public CarId() {
        }

        public CarId(String model, int series) {
            this.model = model;
            this.series = series;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CarId carId = (CarId) o;
            return series == carId.series && Objects.equals(model, carId.model);
        }

        @Override
        public int hashCode() {
            return Objects.hash(model, series);
        }
    }
}


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "model")
//    String model;
//
//    @Column(name = "series")
//    int series;
//
//    @OneToOne(mappedBy = "car")
//    private User user;
//
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Car() {
//    }
//
//    public Car(String model, int series) {
//        this.model = model;
//        this.series = series;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public int getSeries() {
//        return series;
//    }
//
//    public void setSeries(int series) {
//        this.series = series;
//    }
//}
