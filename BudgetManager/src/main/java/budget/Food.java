package budget;

import java.io.Serializable;

public class Food extends Purchase implements Serializable {
    public Food(String name, Double price) {
        super(PurchaseCategory.FOOD, name, price);
    }
}
