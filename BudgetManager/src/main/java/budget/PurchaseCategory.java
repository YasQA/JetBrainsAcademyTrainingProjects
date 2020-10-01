package budget;

import java.io.Serializable;

public enum PurchaseCategory implements Serializable {
    FOOD, CLOTHES, ENTERTAINMENT, OTHER;

    public static PurchaseCategory getByNumber(int number) {
        switch (number) {
            case 1:
                return PurchaseCategory.FOOD;
            case 2:
                return PurchaseCategory.CLOTHES;
            case 3:
                return PurchaseCategory.ENTERTAINMENT;
            default:
                return PurchaseCategory.OTHER;
        }
    }

    public static String stringValue(PurchaseCategory category) {
        switch (category) {
            case FOOD:
                return "Food";
            case CLOTHES:
                return "Clothes";
            case ENTERTAINMENT:
                return "Entertainment";
            case OTHER:
                return "Other";
            default:
                return ("Wrong Purchase Category");
        }
    }
}