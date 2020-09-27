package budget;

import java.io.Serializable;

public class Clothes extends Purchase implements Serializable {
    public Clothes(String name, Double price) {
        super(PurchaseCategory.CLOTHES, name, price);
    }
}
