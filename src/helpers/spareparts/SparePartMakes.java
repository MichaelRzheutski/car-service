package helpers.spareparts;

public enum SparePartMakes {
    ENGINE_OIL_MAKE("Mobil 1"),
    TIRE_SET_MAKE("Белшина"),
    BRAKE_SET_MAKE("Шустрые тормоза");

    private final String sparePartMake;

    SparePartMakes(String sparePartType) {
        this.sparePartMake = sparePartType;
    }

    public String getSparePartMake() {
        return sparePartMake;
    }

    @Override
    public String toString() {
        return sparePartMake;
    }
}
