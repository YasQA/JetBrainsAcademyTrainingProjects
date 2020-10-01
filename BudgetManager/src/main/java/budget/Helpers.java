package budget;

import java.util.List;

public class Helpers {
    public static double getPurchasesSum(List<Purchase> purchasesList) {
        double purchaseSum = 0;
        for (Purchase purchase : purchasesList) {
            purchaseSum += purchase.getPrice();
        }
        return purchaseSum;
    }
}
