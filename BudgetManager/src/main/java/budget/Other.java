package budget;

import java.io.Serializable;

public class Other extends Purchase implements Serializable {
    public Other(String name, Double price) {
        super(PurchaseCategory.OTHER, name, price);
    }
}
