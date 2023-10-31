package car;

import static java.lang.String.format;

// Car: Represents make, model, year and mileage of a car
public class Car {
    private String make;
    private String model;
    private String year;
    private int mileage;

    public Car(String make, String model, String year, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    // Display car fullName
    public static String createCarFullName(String make, String model) {
        return format("%s %s", make, model);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
