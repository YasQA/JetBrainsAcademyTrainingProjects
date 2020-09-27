package budget;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;
    private double balance;
    public boolean isON;

    public transient Menu menu = new Menu(this);

    public List<Purchase> purchaseList = new ArrayList<>();
    public List<Income> incomeList = new ArrayList<>();

    public Budget() {
        balance = 0;
        isON = true;
    }

    public double getPurchasesSum() {
        double purchaseSum = 0;
        for (Purchase purchase : purchaseList) {
            purchaseSum += purchase.getPrice();
        }
        return purchaseSum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance  = balance > 0 ? balance : 0;
    }

    public void showBalance() {
        System.out.println("Balance: $" + String.format("%.2f", getBalance()));
        System.out.println();
    }

    public void addIncome() {
        Income income = new Income();
        System.out.println("Enter income:");
        try {
            double in = Double.parseDouble(Main.sc.nextLine());
            income.setIncome(in);
            incomeList.add(income);
            setBalance(getBalance() + in);
            System.out.println("Income was added!");
        } catch (Exception exception) {
            System.out.println("Wrong income value!");
        }
        System.out.println();
    }

    public void addPurchase() {
        boolean isOnAddPurchase = true;
        PurchaseCategory category;
        String purchaseName;
        double purchasePrice;
        while (isOnAddPurchase) {

            System.out.println("Choose the type of purchase");
            System.out.println(menu.addPurchaseMenuString);

            int menuItemSelected = Integer.parseInt(Main.sc.nextLine());
            System.out.println();

            if (menuItemSelected > 5 || menuItemSelected < 1) {
                System.out.println("Wrong number!");
                System.out.println();

            } else if (menuItemSelected == 5) {
                isOnAddPurchase = false;

            } else {
                category = getPurchaseCategoryByNumber(menuItemSelected);

                System.out.println("Enter purchase name:");
                purchaseName = Main.sc.nextLine();
                System.out.println("Enter its price:");
                purchasePrice = Double.parseDouble(Main.sc.nextLine());

                switch (category) {
                    case FOOD:
                        purchaseList.add(new Food(purchaseName, purchasePrice));
                        break;
                    case CLOTHES:
                        purchaseList.add(new Clothes(purchaseName, purchasePrice));
                        break;
                    case ENTERTAINMENT:
                        purchaseList.add(new Entertainment(purchaseName, purchasePrice));
                        break;
                    case OTHER:
                        purchaseList.add(new Other(purchaseName, purchasePrice));
                        break;
                }

                setBalance(getBalance() - purchasePrice);
                System.out.println("Purchase was added!");
                System.out.println();
            }
        }
    }

    public PurchaseCategory getPurchaseCategoryByNumber(int number) {
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

    public void listPurchases() {
        boolean isOnListPurchase = true;
        if (purchaseList.size() == 0) {
            System.out.println("Purchase list is empty");
        } else {
            while (isOnListPurchase) {
                System.out.println("Choose the type of purchases");
                System.out.println(menu.showPurchaseMenuString);
                int menuItemSelected = Integer.parseInt(Main.sc.nextLine());

                if (menuItemSelected > 6 || menuItemSelected < 1) {
                    System.out.println("Wrong number!");
                    System.out.println();

                } else if (menuItemSelected == 6) {
                    isOnListPurchase = false;

                } else if (menuItemSelected == 5) {
                    System.out.println();
                    System.out.println("All:");
                    for (Purchase purchase : purchaseList) {
                        System.out.println(purchase.toString());
                    }
                    System.out.println("Total sum: $" + String.format("%.2f", getPurchasesSum()));

                } else {
                    double categorySum = 0;
                    List<Purchase> categoryList = new ArrayList<>();
                    PurchaseCategory category = getPurchaseCategoryByNumber(menuItemSelected);

                    for (Purchase purchase : purchaseList) {
                        if (category.equals(purchase.getCategory())) {
                            categoryList.add(purchase);
                            categorySum += purchase.getPrice();
                        }
                    }

                    System.out.println();

                    if (categoryList.size() == 0) {
                        System.out.println(category + ":");
                        System.out.println("Purchase list is empty!");
                    } else {
                        System.out.println(category + ":");
                        for (Purchase purchase : categoryList) {
                            System.out.println(purchase.toString());
                        }
                        System.out.println("Total sum: $" + String.format("%.2f", categorySum));
                    }
                }
                System.out.println();
            }
        }
    }

    public void save() {
        SerializationUtils.saveBudget(this, Main.fileName);
        System.out.println("Purchases were saved!");
        System.out.println();
    }

    public void load() {
        File file = new File(Main.fileName);
        if (file.isFile()) {
            Budget tempBudget = SerializationUtils.loadBudget(file.getName());
            this.balance = tempBudget.balance;
            this.purchaseList = tempBudget.purchaseList;
            this.incomeList = tempBudget.incomeList;
            System.out.println("Purchases were loaded!");
        } else {
            System.out.println("Cannot load data, file is not available!");
        }
        System.out.println();
    }

    public void exit() {
        isON = false;
        System.out.println("Bye!");
    }
}
