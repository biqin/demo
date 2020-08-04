import java.util.Arrays;
import java.util.List;

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println(this.toString() + " Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}

//和lambda配套使用，用已经实现的方法代替lambda实现
public class FunctionRefTest {
    @FunctionalInterface
    public interface CarFactory<P extends Car> {
        P create(String name);
    }

    public static void test() {
        CarFactory<Car> carFactory = Car::new;

        List<Car> cars = Arrays.asList(carFactory.create("1"), carFactory.create("2"), carFactory.create("3"));

        //传入静态方法
        cars.forEach(Car::collide);

        //传入普通成员方法，默认传入了this
        cars.forEach(Car::repair);

        //传入具体对象的成员方法
        Car newCar = carFactory.create("newCar");
        cars.forEach(newCar::follow);
    }
}
