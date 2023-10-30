// SparePart: Represents the spare part name and availability in stock
public class SparePart {
    private String sparePartName;
    private boolean isInStock;

    public SparePart(String sparePartName, boolean isInStock) {
        this.sparePartName = sparePartName;
        this.isInStock = isInStock;
    }

    public String getSparePartName() {
        return sparePartName;
    }

    public void setSparePartName(String sparePart) {
        this.sparePartName = sparePart;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }
}
