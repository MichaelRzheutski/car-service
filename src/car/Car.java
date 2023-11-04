package car;

import helpers.cars.CarYears;
import helpers.cars.Cars;

import java.util.Arrays;
import java.util.Objects;

import static helpers.ConsoleColors.*;

// Car: Represents make, model, year and mileage of a car
public class Car {
    private Cars carMake;
    private CarYears carManufactureYear;
    private int mileage;
    private SparePart[] spareParts;

    public Car() {
    }

    public Car(
            Cars carMake, CarYears carManufactureYear,
            int mileage, SparePart[] spareParts) {
        this.carMake = carMake;
        this.carManufactureYear = carManufactureYear;
        this.mileage = mileage;
        this.spareParts = spareParts;
    }

    public static void showCars(Car[] cars) {
        for (Car car : cars) {
            System.out.println(
                    ANSI_GREEN + "Марка автомобиля: " + ANSI_YELLOW
                            + car.getCarMake() + ANSI_RESET
            );
            System.out.println(
                    ANSI_GREEN + "Год выпуска: " + ANSI_YELLOW
                            + car.getCarManufactureYear() + ANSI_RESET
            );
            System.out.println(
                    ANSI_GREEN + "Пробег км: " + ANSI_YELLOW
                            + car.getMileage() + ANSI_RESET
            );
            System.out.println(
                    ANSI_GREEN + "Информация о запчастях: " + ANSI_YELLOW
                            + Arrays.toString(car.getSpareParts()) + ANSI_RESET
            );
            System.out.println();
        }
    }

    public Cars getCarMake() {
        return carMake;
    }

    public void setCarMake(Cars carMake) {
        this.carMake = carMake;
    }

    public CarYears getCarManufactureYear() {
        return carManufactureYear;
    }

    public void setCarManufactureYear(CarYears carManufactureYear) {
        this.carManufactureYear = carManufactureYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public SparePart[] getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(SparePart[] spareParts) {
        this.spareParts = spareParts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carManufactureYear == car.carManufactureYear
                && mileage == car.mileage
                && Objects.equals(carMake, car.carMake)
                && Arrays.equals(spareParts, car.spareParts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(carMake, carManufactureYear, mileage);
        result = 31 * result + Arrays.hashCode(spareParts);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carMake='" + carMake + '\'' +
                ", carManufactureYear=" + carManufactureYear +
                ", mileage=" + mileage +
                ", spareParts=" + Arrays.toString(spareParts) +
                '}';
    }
}
