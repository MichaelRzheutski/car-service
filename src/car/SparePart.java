package car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import static helpers.ConsoleColors.ANSI_RESET;
import static helpers.ConsoleColors.ANSI_YELLOW;

// SparePart: Represents type, make, cost, delivery days
// and availability spares in stock
public class SparePart extends Car {
    private String sparePartType;
    private String sparePartMake;
    private String isInStock;
    private double sparePartCost;
    private int deliveryDays;

    // Setup Logger log4j2
    static {
        System.setProperty("log4j.configurationFile", "lib/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger();

    public SparePart(
            String sparePartType, String sparePartMake,
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
    public static SparePart[] calcSparePartCost(Car[] cars, SparePart[] spareParts) {
        double result = 0;
        int sparePartsDeliveryDays;
        for (Car car : cars) {

            for (SparePart sparePart : spareParts) {

                if (car.getCarManufactureYear() > 2015) {
                    result = sparePart.getSparePartCost();
                    sparePart.setSparePartCost(result *= 1.5);

                    if (sparePart.getDeliveryDays() > 0) {
                        sparePartsDeliveryDays = sparePart.getDeliveryDays() * 2;
                        sparePart.setSparePartCost(result += sparePartsDeliveryDays);
                    }

                }

                break;
            }

            LOGGER.info(car + "\n");
        }

        return spareParts;
    }

    public String getSparePartType() {
        return sparePartType;
    }

    public void setSparePartType(String sparePart) {
        this.sparePartType = sparePart;
    }

    public String getSparePartMake() {
        return sparePartMake;
    }

    public void setSparePartMake(String sparePartMake) {
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
        return Double.compare(sparePart.sparePartCost, sparePartCost) == 0
                && deliveryDays == sparePart.deliveryDays
                && Objects.equals(sparePartType, sparePart.sparePartType)
                && Objects.equals(sparePartMake, sparePart.sparePartMake)
                && Objects.equals(isInStock, sparePart.isInStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sparePartType, sparePartMake,
                isInStock, sparePartCost, deliveryDays);
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
