package car;

import customlinkedlist.CustomLinkedList;
import helpers.ObjectsCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

import static helpers.ConsoleColors.ANSI_RESET;
import static helpers.ConsoleColors.ANSI_YELLOW;

// SparePart: Represents type, make, cost, delivery days
// and availability spares in stock
public class SparePart extends Car {
    private String sparePartType;
    private String sparePartMake;
    private String isInStock;
    private BigDecimal sparePartCost;
    private int deliveryDays;

    // Setup Logger log4j2
    static {
        System.setProperty("log4j.configurationFile", "lib/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger();

    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();

    public SparePart(
            String sparePartType, String sparePartMake,
            String isInStock, BigDecimal sparePartCost
    ) {
        this.sparePartType = sparePartType;
        this.sparePartMake = sparePartMake;
        this.isInStock = isInStock;
        this.sparePartCost = sparePartCost;
        if (isInStock.equals("нет")) {
            this.deliveryDays = generateDeliveryDays();
        }
    }

    public static List<Car> showSpareParts(List<Car> cars, List<SparePart> spareParts) {
        for (Car car : cars) {
            LOGGER.info(car + "\n");
        }

        return cars;
    }

    // Method generates random delivery days
    public static int generateDeliveryDays() {
        return (int) (Math.random() * 7) + 1;
    }

    // Method calculates spare part costs depends on car manufacture year
    public static List<SparePart> calcSparePartCost(List<Car> cars, CustomLinkedList<SparePart> spareParts) {
        BigDecimal result;
        int sparePartsDeliveryDays;

        // Reset spare part costs to initial values
        final BigDecimal firstSparePartInitialCost = spareParts.get(0).getSparePartCost();
        spareParts.get(0).setSparePartCost(firstSparePartInitialCost);

        final BigDecimal secondSparePartInitialCost = spareParts.get(0).getSparePartCost();
        spareParts.get(0).setSparePartCost(secondSparePartInitialCost);

        final BigDecimal thirdSparePartInitialCost = spareParts.get(0).getSparePartCost();
        spareParts.get(0).setSparePartCost(thirdSparePartInitialCost);

        // Calculate spare part costs
        for (Car car : cars) {

            for (SparePart sparePart : spareParts) {

                if (car.getCarManufactureYear() > 2015) {
                    result = sparePart.getSparePartCost();
                    sparePart.setSparePartCost(result = result.multiply(
                            BigDecimal.valueOf(1.5).setScale(2, RoundingMode.UNNECESSARY))
                    );

                    if (sparePart.getDeliveryDays() > 0) {
                        sparePartsDeliveryDays = sparePart.getDeliveryDays() * 2;
                        sparePart.setSparePartCost(result = result.add(
                                BigDecimal.valueOf(sparePartsDeliveryDays)
                                        .setScale(2, RoundingMode.UNNECESSARY))
                        );
                    }

                }

                break;
            }

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

    public BigDecimal getSparePartCost() {
        return sparePartCost;
    }

    public void setSparePartCost(BigDecimal sparePartCost) {
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
        return deliveryDays == sparePart.deliveryDays
                && Objects.equals(sparePartType, sparePart.sparePartType)
                && Objects.equals(sparePartMake, sparePart.sparePartMake)
                && Objects.equals(isInStock, sparePart.isInStock)
                && Objects.equals(sparePartCost, sparePart.sparePartCost);
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
