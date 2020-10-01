package budget;

import java.util.List;

public class PurchaseCategorySum {
    final private PurchaseCategory category;
    final private double sum;

    public PurchaseCategorySum(PurchaseCategory category, double sum) {
        this.category = category;
        this.sum = sum;
    }

    public PurchaseCategory getCategory() {
        return category;
    }

    public double getSum() {
        return sum;
    }

    public static double getSum(PurchaseCategory category, List<Purchase> purchaseList) {
        double categorySum = 0;

        for (Purchase purchase : purchaseList) {
            if (category.equals(purchase.getCategory())) {
                categorySum += purchase.getPrice();
            }
        }
        return categorySum;
    }

    public int compareTo(PurchaseCategorySum element) {
        int res = 0;
        if (this.sum < element.getSum()) {
            res = -1;
        }
        if (this.sum > element.getSum()) {
            res = 1;
        }
        return res;
    }

    @Override
    public String toString() {
        return PurchaseCategory.stringValue(getCategory()) + " - $" + String.format("%.2f", getSum());
    }
}
