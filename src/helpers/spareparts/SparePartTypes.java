package helpers.spareparts;

public enum SparePartTypes {
    ENGINE_OIL("Моторное масло"),
    TIRE_SET("Комплект шин"),
    BRAKE_SET("Комплект тормозов");

    private final String sparePartType;

    SparePartTypes(String sparePartType) {
        this.sparePartType = sparePartType;
    }

    public String getSparePartType() {
        return sparePartType;
    }

    @Override
    public String toString() {
        return sparePartType;
    }
}
