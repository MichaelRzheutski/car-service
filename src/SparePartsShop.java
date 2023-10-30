import java.util.Formatter;
import java.util.Locale;

// SparePartsShop: Represents the name and cost of the spare part which on sale
public class SparePartsShop extends CarService {
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
                        "Запчасть '%s' в наличии в магазине по цене %.2f\n",
                        spares.getSparePartName().getSparePartName(),
                        spares.getSparePartCost());
                System.out.printf(sparePartFormat.toString());
            } else {
                System.out.printf(
                        "Запчасть '%s' отсутствует в магазине\n",
                        spares.getSparePartName().getSparePartName()
                );
            }
        }
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
}
