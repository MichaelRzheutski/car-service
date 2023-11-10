package car;

import interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

import static helpers.ConsoleColors.*;

// Car: Represents make, model, manufacture year, mileage and spare parts
public class Car implements Washable, Paintable, BodyRepairable,
        Electronicable, Modernizable {
    protected String carMake;
    protected int carManufactureYear;
    protected int mileage;
    protected SparePart[] spareParts;
    private String carWash;
    private String carPaint;
    private String bodyRepairment;
    private String electronicsRepairment;
    private String modernization;

    // Setup Logger log4j2
    static {
        System.setProperty("log4j.configurationFile", "lib/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger();

    public Car() {
    }

    public Car(
            String carMake, int carManufactureYear,
            int mileage, SparePart[] spareParts
    ) {
        this.carMake = carMake;
        this.carManufactureYear = carManufactureYear;
        this.mileage = mileage;
        this.spareParts = spareParts;
    }

    public Car(
            String carMake, int carManufactureYear,
            int mileage
    ) {
        this.carMake = carMake;
        this.carManufactureYear = carManufactureYear;
        this.mileage = mileage;
    }

    public Car(
            String carMake, int carManufactureYear
    ) {
        this.carMake = carMake;
        this.carManufactureYear = carManufactureYear;
    }

    @Override
    public String isWashed(boolean carWash) {
        String result;

        if (carWash) {
            setCarWash("Машина помыта");
        } else {
            setCarWash("Машина не помыта");
        }
        result = getCarWash();
        LOGGER.info(
                ANSI_GREEN + "Внешний вид машины: " + ANSI_RESET
                        + getCarWash() + ANSI_RESET
        );

        return result;
    }

    @Override
    public String isPainted(boolean carPaint) {
        String result;

        if (carPaint) {
            setCarPaint("Машина перекрашена");
        } else {
            setCarPaint("Машина не перекрашивалась");
        }
        result = getCarPaint();
        LOGGER.info(
                ANSI_GREEN + "Покраска кузова: " + ANSI_RESET
                        + getCarPaint() + ANSI_RESET
        );

        return result;
    }

    @Override
    public String isBodyRepaired(boolean bodyRepairment) {
        String result;

        if (bodyRepairment) {
            setBodyRepairment("Проводился ремонт кузова");
        } else {
            setBodyRepairment("Ремонт кузова не проводился");
        }
        result = getBodyRepairment();
        LOGGER.info(
                ANSI_GREEN + "Состояние кузова: " + ANSI_RESET
                        + getBodyRepairment() + ANSI_RESET
        );

        return result;
    }

    @Override
    public String isElectronicsRepaired(boolean electronicsRepairment) {
        String result;

        if (electronicsRepairment) {
            setElectronicsRepairment("Проведён ремонт и замена электроники");
        } else {
            setElectronicsRepairment("Ремонта и замены электроники не проводилось");
        }
        result = getElectronicsRepairment();
        LOGGER.info(
                ANSI_GREEN + "Состояние электроники: " + ANSI_RESET
                        + getElectronicsRepairment() + ANSI_RESET
        );

        return result;
    }

    @Override
    public String isModernized(boolean modernization) {
        String result;

        if (modernization) {
            setModernization("Автомобиль модернизирован");
        } else {
            setModernization("Модернизация не проводилась");
        }
        result = getModernization();
        LOGGER.info(
                ANSI_GREEN + "Модернизация: " + ANSI_RESET
                        + getModernization() + ANSI_RESET
        );

        return result;
    }

    public final Car[] showCars(Car[] cars, SparePart[] spareParts) {

        for (Car car : cars) {
            LOGGER.info(
                    ANSI_GREEN + "Марка автомобиля: " + ANSI_YELLOW
                            + car.getCarMake() + ANSI_RESET
            );
            LOGGER.info(
                    ANSI_GREEN + "Год выпуска: " + ANSI_YELLOW
                            + car.getCarManufactureYear() + ANSI_RESET
            );
            LOGGER.info(
                    ANSI_GREEN + "Пробег км: " + ANSI_YELLOW
                            + car.getMileage() + ANSI_RESET
            );

            if (car.getCarMake().equals("BMW X6")) {
                isWashed(true);
                isPainted(false);
                isBodyRepaired(true);
                isElectronicsRepaired(false);
                isModernized(true);
            }

            if (car.getCarMake().equals("Toyota Land Cruiser")) {
                isWashed(false);
                isPainted(true);
                isBodyRepaired(false);
                isElectronicsRepaired(true);
                isModernized(false);
            }

            if (car.getCarMake().equals("Mercedes Benz")) {
                isWashed(true);
                isPainted(true);
                isBodyRepaired(false);
                isElectronicsRepaired(false);
                isModernized(true);
            }

            LOGGER.info(
                    ANSI_GREEN + "Информация о запчастях: " + ANSI_RESET
                            + Arrays.toString(car.getSpareParts()) + "\n" + ANSI_RESET
            );
        }

        return cars;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public int getCarManufactureYear() {
        return carManufactureYear;
    }

    public void setCarManufactureYear(int carManufactureYear) {
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

    public String getCarWash() {
        return carWash;
    }

    public void setCarWash(String carWash) {
        this.carWash = carWash;
    }

    public String getCarPaint() {
        return carPaint;
    }

    public void setCarPaint(String carPaint) {
        this.carPaint = carPaint;
    }

    public String getBodyRepairment() {
        return bodyRepairment;
    }

    public void setBodyRepairment(String bodyRepairment) {
        this.bodyRepairment = bodyRepairment;
    }

    public String getElectronicsRepairment() {
        return electronicsRepairment;
    }

    public void setElectronicsRepairment(String electronicsRepairment) {
        this.electronicsRepairment = electronicsRepairment;
    }

    public String getModernization() {
        return modernization;
    }

    public void setModernization(String modernization) {
        this.modernization = modernization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carManufactureYear == car.carManufactureYear
                && mileage == car.mileage
                && Objects.equals(carMake, car.carMake)
                && Arrays.equals(spareParts, car.spareParts)
                && Objects.equals(carWash, car.carWash)
                && Objects.equals(carPaint, car.carPaint)
                && Objects.equals(bodyRepairment, car.bodyRepairment)
                && Objects.equals(electronicsRepairment, car.electronicsRepairment)
                && Objects.equals(modernization, car.modernization);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(carMake, carManufactureYear, mileage,
                carWash, carPaint, bodyRepairment, electronicsRepairment, modernization);
        result = 31 * result + Arrays.hashCode(spareParts);
        return result;
    }

    @Override
    public String toString() {
        return ANSI_GREEN + "Марка авто: " + ANSI_YELLOW + carMake + ", " + ANSI_RESET +
                ANSI_GREEN + "Год выпуска авто: " + ANSI_YELLOW + carManufactureYear + ", " + ANSI_RESET +
                ANSI_GREEN + "Пробег: " + ANSI_YELLOW + mileage + ", " + ANSI_RESET +
                ANSI_GREEN + "Запчасти: " + ANSI_YELLOW + Arrays.toString(spareParts) + ", " + ANSI_RESET;
    }
}
