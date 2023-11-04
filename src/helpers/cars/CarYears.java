package helpers.cars;

public enum CarYears {
    YEAR_2023(2023),
    YEAR_2020(2020),
    YEAR_2015(2015);

    private final int carYear;

    CarYears(int carYear) {
        this.carYear = carYear;
    }

    public int getCarMake() {
        return carYear;
    }

    @Override
    public String toString() {
        return String.valueOf(carYear);
    }
}
