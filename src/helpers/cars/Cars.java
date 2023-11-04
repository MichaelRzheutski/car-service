package helpers.cars;

public enum Cars {
    BMW_X6("BMW X6"),
    TOYOTA_LAND_CRUISER("Toyota Land Cruiser"),
    MERCEDES_BENZ("Mercedes Benz");

    private final String carMake;

    Cars(String sparePartType) {
        this.carMake = sparePartType;
    }

    public String getCarMake() {
        return carMake;
    }

    @Override
    public String toString() {
        return carMake;
    }
}
