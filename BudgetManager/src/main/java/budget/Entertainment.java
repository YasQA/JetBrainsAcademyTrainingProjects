package budget;

import java.io.Serializable;

public class Entertainment extends Purchase implements Serializable {
    public Entertainment(String name, Double price) {
        super(PurchaseCategory.ENTERTAINMENT, name, price);
    }
}
