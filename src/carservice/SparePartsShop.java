package carservice;

import car.SparePart;

import java.util.Formatter;
import java.util.Locale;
import java.util.Objects;

import static helpers.ConsoleColors.ANSI_GREEN;

// SparePartsShop: Represents the name and cost of the spare part which is on sale
public class SparePartsShop extends CarService {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private SparePart sparePartName;
    private double sparePartCost;

    public SparePartsShop(SparePart sparePartName, double sparePartCost) {
        this.sparePartName = sparePartName;
        this.sparePartCost = sparePartCost;
    }

    // Method shows available and sold out spare parts in the service shop
    public static void showSparePartsInStore(SparePartsShop[] sparePartsInShop) {
        for (SparePartsShop spares : sparePartsInShop) {
            if (spares.getSparePartName().isInStock()) {
                Formatter sparePartFormat = new Formatter(Locale.US).format(
                        ANSI_GREEN + "Запчасть " + ANSI_YELLOW + "'%s'" + ANSI_GREEN
                                + " в наличии в магазине по цене " + ANSI_YELLOW + "%.2f\n" + ANSI_RESET,
                        spares.getSparePartName().getSparePartType(),
                        spares.getSparePartCost());
                System.out.printf(sparePartFormat.toString());
            } else {
                System.out.printf(
                        ANSI_GREEN + "Запчасть " + ANSI_YELLOW + "'%s'" + ANSI_GREEN
                                + " отсутствует в магазине\n" + ANSI_RESET,
                        spares.getSparePartName().getSparePartType()
                );
            }
        }
        System.out.println();
    }

    public SparePart getSparePartName() {
        return sparePartName;
    }

    public void setSparePartName(SparePart sparePartName) {
        this.sparePartName = sparePartName;
    }

    public double getSparePartCost() {
        return sparePartCost;
    }

    public void setSparePartCost(double sparePartCost) {
        this.sparePartCost = sparePartCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SparePartsShop sparePartsShop = (SparePartsShop) o;
        return Double.compare(sparePartsShop.sparePartCost, sparePartCost) == 0
                && Objects.equals(sparePartName, sparePartsShop.sparePartName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sparePartName, sparePartCost);
    }

    @Override
    public String toString() {
        return "SparePartsShop{" +
                "sparePartName=" + sparePartName +
                ", sparePartCost=" + sparePartCost +
                '}';
    }
}
