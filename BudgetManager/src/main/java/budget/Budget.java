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
            System.out.println(Menu.ADD_PURCHASE_MENU);

            int menuItemSelected = Integer.parseInt(Main.sc.nextLine());
            System.out.println();

            if (menuItemSelected > 5 || menuItemSelected < 1) {
                System.out.println("Wrong selection!");
                System.out.println();

            } else if (menuItemSelected == 5) {
                isOnAddPurchase = false;

            } else {
                category = PurchaseCategory.getByNumber(menuItemSelected);

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

    public void listPurchases() {
        boolean isOnListPurchase = true;
        List<Purchase> categoryList;
        PurchaseCategory category;
        double categorySum;

        if (purchaseList.size() == 0) {
            System.out.println("Purchase list is empty");
        } else {
            while (isOnListPurchase) {
                System.out.println("Choose the type of purchases");
                System.out.println(Menu.SHOW_PURCHASE_MENU);
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
                    System.out.println("Total sum: $" + String.format("%.2f", Helpers.getPurchasesSum(purchaseList)));

                } else {
                    category = PurchaseCategory.getByNumber(menuItemSelected);
                    categoryList = getCategoryList(category);
                    categorySum = PurchaseCategorySum.getSum(category, purchaseList);

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

    public List<Purchase> getCategoryList(PurchaseCategory category) {
        List<Purchase> categoryList = new ArrayList<>();

        for (Purchase purchase : purchaseList) {
            if (category.equals(purchase.getCategory())) {
                categoryList.add(purchase);
            }
        }
        return  categoryList;
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

    public void sort() {
        boolean isOnSort = true;

        while (isOnSort) {
            System.out.println("How do you want to sort?");
            System.out.println(Menu.SORT_MENU);

            int menuItemSelected = Integer.parseInt(Main.sc.nextLine());
            System.out.println();

            if (menuItemSelected > 4 || menuItemSelected < 1) {
                System.out.println("Wrong selection!");
                System.out.println();

            } else if (menuItemSelected == 4) {
                isOnSort = false;
            } else {
                switch (menuItemSelected) {
                    case 1:
                        Analyze.sortAll(purchaseList);
                        break;
                    case 2:
                        Analyze.sortByType(purchaseList);
                        break;
                    case 3:
                        Analyze.sortCertainType(purchaseList);
                        break;
                }
            }
        }
    }

    public void exit() {
        isON = false;
        System.out.println("Bye!");
    }
}
