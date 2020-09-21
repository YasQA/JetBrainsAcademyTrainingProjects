package budget;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double balance = 0;
    boolean isON = true;

    Menu menu = new Menu(this);

    List<Purchase> purchaseList = new ArrayList<>();
    List<Income> incomeList = new ArrayList<>();


    public double getPurchasesSum() {
        double purchaseSum = 0;
        for (Purchase purchase : purchaseList) {
            purchaseSum += purchase.getPrice();
        }
        return purchaseSum;
    }

//    public double getIncomesSum() {
//        double incomeSum = 0;
//        for (Income income : incomeList) {
//            incomeSum += income.getIncome();
//        }
//        return incomeSum;
//    }

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
        String purchaseName;
        double purchasePrice;
        try {
            System.out.println("Enter purchase name:");
            purchaseName = Main.sc.nextLine();
            System.out.println("Enter its price:");
            purchasePrice = Double.parseDouble(Main.sc.nextLine());
            Purchase purchase = new Purchase(purchaseName, purchasePrice);
            purchaseList.add(purchase);
            balance -= purchasePrice;
            System.out.println("Purchase was added!");
        } catch (Exception exception) {
            System.out.println("Wrong purchase value!");
        }
        System.out.println();
    }

    public void listPurchases() {
        if (purchaseList.size() == 0) {
            System.out.println("Purchase list is empty");
        } else {
            for(Purchase purchase : purchaseList) {
                System.out.println(purchase.toString());
            }
            System.out.println("Total sum: $" + String.format("%.2f", getPurchasesSum()));
        }
        System.out.println();
    }

    public void exit() {
        isON = false;
        System.out.println();
        System.out.println("Bye!");
    }
}
