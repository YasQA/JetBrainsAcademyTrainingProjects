package budget;

import java.io.Serializable;

public class Purchase implements Serializable {
    final private String name;
    final private double price;
    final private PurchaseCategory category;

    public Purchase (PurchaseCategory category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public PurchaseCategory getCategory() {
        return category;
    }


    public int compareTo(Purchase element) {
        int res = 0;
        if (this.price < element.getPrice()) {
            res = -1;
        }
        if (this.price > element.getPrice()) {
            res = 1;
        }
        return res;
    }

    @Override
    public String toString() {
        return getName() + " $" + String.format("%.2f", getPrice());
    }

}
