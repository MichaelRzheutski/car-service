package car;

import helpers.spareparts.SparePartMakes;
import helpers.spareparts.SparePartTypes;

import java.util.Objects;

import static helpers.ConsoleColors.ANSI_RESET;
import static helpers.ConsoleColors.ANSI_YELLOW;

// SparePart: Represents the spare part name and availability in stock
public class SparePart extends Car {
    private SparePartTypes sparePartType;
    private SparePartMakes sparePartMake;
    private String isInStock;
    private double sparePartCost;
    private int deliveryDays;

    public SparePart(
            SparePartTypes sparePartType, SparePartMakes sparePartMake,
            String isInStock, double sparePartCost
    ) {
        this.sparePartType = sparePartType;
        this.sparePartMake = sparePartMake;
        this.isInStock = isInStock;
        this.sparePartCost = sparePartCost;
        if (isInStock.equals("нет")) {
            this.deliveryDays = generateDeliveryDays();
        }
    }

    // Method generates random delivery days
    public static int generateDeliveryDays() {
        return (int) (Math.random() * 7) + 1;
    }

    // Method calculates spare part costs depends on car manufacture year
    public static void calculateSparePartCost(SparePart[] spareParts, Car[] cars) {
        for (Car car : cars) {
            double tempCost = 0;

            if (car.getCarManufactureYear() > 2015) {
                for (SparePart sparePart : spareParts) {
                    tempCost = sparePart.getSparePartCost();

                    sparePart.setSparePartCost(tempCost *= 0.8);
                }
            }

            System.out.println(car);
            System.out.println();
        }
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

    public String isInStock() {
        return isInStock;
    }

    public void setInStock(String inStock) {
        isInStock = inStock;
    }

    public double getSparePartCost() {
        return sparePartCost;
    }

    public void setSparePartCost(double sparePartCost) {
        this.sparePartCost = sparePartCost;
    }

    public int getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(int deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SparePart sparePart = (SparePart) o;
        return Double.compare(sparePart.sparePartCost, sparePartCost) == 0 && deliveryDays == sparePart.deliveryDays && sparePartType == sparePart.sparePartType && sparePartMake == sparePart.sparePartMake && Objects.equals(isInStock, sparePart.isInStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sparePartType, sparePartMake, isInStock, sparePartCost, deliveryDays);
    }

    @Override
    public String toString() {
        return ANSI_RESET + "\nТип запчасти: " + ANSI_YELLOW + sparePartType + "," + ANSI_RESET +
                ANSI_RESET + " Марка запчасти: " + ANSI_YELLOW + sparePartMake + "," + ANSI_RESET +
                ANSI_RESET + " Наличие в магазине: " + ANSI_YELLOW + isInStock + ANSI_RESET +
                ANSI_RESET + " Стоимость: " + ANSI_YELLOW + sparePartCost + ANSI_RESET +
                ANSI_RESET + " Срок поставки: " + ANSI_YELLOW + deliveryDays + ANSI_RESET;
    }
}
