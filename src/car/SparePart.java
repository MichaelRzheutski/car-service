package car;

import helpers.spareparts.SparePartMakes;
import helpers.spareparts.SparePartTypes;

import java.util.Objects;

// SparePart: Represents the spare part name and availability in stock
public class SparePart extends Car {
    private SparePartTypes sparePartType;
    private SparePartMakes sparePartMake;
    private boolean isInStock;

    public SparePart(SparePartTypes sparePartType, SparePartMakes sparePartMake, boolean isInStock) {
        this.sparePartType = sparePartType;
        this.sparePartMake = sparePartMake;
        this.isInStock = isInStock;
    }

    public SparePartTypes getSparePartType() {
        return sparePartType;
    }

    public void setSparePartType(SparePartTypes sparePart) {
        this.sparePartType = sparePart;
    }

    public SparePartMakes getSparePartMake() {
        return sparePartMake;
    }

    public void setSparePartMake(SparePartMakes sparePartMake) {
        this.sparePartMake = sparePartMake;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SparePart sparePart = (SparePart) o;
        return isInStock == sparePart.isInStock
                && Objects.equals(sparePartType, sparePart.sparePartType)
                && Objects.equals(sparePartMake, sparePart.sparePartMake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sparePartType, sparePartMake, isInStock);
    }

    @Override
    public String toString() {
        return "Тип запчасти: " + sparePartType + ", " +
                " Марка запчасти: " + sparePartMake + ", " +
                " Наличие на складе: " + isInStock;
    }
}
