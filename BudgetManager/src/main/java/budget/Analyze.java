package budget;

import java.util.ArrayList;
import java.util.List;

public class Analyze {
    public static void sortAll(List<Purchase> purchaseList) {
        if (purchaseList.size() == 0) {
            System.out.println("Purchase list is empty!");
        } else {
            List<Purchase> resultList = new ArrayList<>(purchaseList);
            BubbleSortList.bubbleSortPurchases(resultList);

            System.out.println("All:");
            for (Purchase purchase : resultList) {
                System.out.println(purchase.toString());
            }
            System.out.println("Total: $" + String.format("%.2f", Helpers.getPurchasesSum(resultList)));
        }
        System.out.println();
    }

    public static void sortByType(List<Purchase> purchaseList) {
        List<PurchaseCategorySum> listCategorySum = new ArrayList<>();
        for (PurchaseCategory category : PurchaseCategory.values()) {
            listCategorySum.add(new PurchaseCategorySum(category, PurchaseCategorySum.getSum(category,purchaseList)));
        }
        BubbleSortList.bubbleSortCategories(listCategorySum);

        System.out.println("Types:");
        if (Helpers.getPurchasesSum(purchaseList) > 0) {
            for (PurchaseCategorySum categorySum : listCategorySum) {
                System.out.println(categorySum.toString());
            }
        }
        System.out.println("Total sum: $" + String.format("%.2f", Helpers.getPurchasesSum(purchaseList)));
        System.out.println();
    }

    public static void sortCertainType(List<Purchase> purchaseList) {
        List<Purchase> categoryList = new ArrayList<>();

        System.out.println("Choose the type of purchases");
        System.out.println(Menu.SORT_TYPE_SELECTION_MENU);

        int typeSelected = Integer.parseInt(Main.sc.nextLine());
        System.out.println();

        PurchaseCategory category = PurchaseCategory.getByNumber(typeSelected);

        for (Purchase purchase : purchaseList) {
            if (category.equals(purchase.getCategory())) {
                categoryList.add(purchase);
            }
        }

        BubbleSortList.bubbleSortPurchases(categoryList);

        if (categoryList.size() == 0) {
            System.out.println("Purchase list is empty!");
        } else {
            System.out.println(category + ":");
            for (Purchase purchase : categoryList) {
                System.out.println(purchase.toString());
            }
            System.out.println("Total sum: $" + String.format("%.2f", Helpers.getPurchasesSum(categoryList)));
        }
        System.out.println();
    }
}