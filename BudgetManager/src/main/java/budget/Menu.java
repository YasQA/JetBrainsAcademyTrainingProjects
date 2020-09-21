package budget;

public class Menu {
    Budget budget;

    public Menu(Budget budget) {
        this.budget = budget;
    }

    public void displayMainMenu() {
        String mainMenuString = "Choose your action:\n"
                + "1) Add income\n"
                + "2) Add purchase\n"
                + "3) Show list of purchases\n"
                + "4) Balance\n"
                + "0) Exit";

        System.out.println(mainMenuString);
    }

    public void actWithMainMenu(String menuItem) {
        System.out.println();
        switch (menuItem) {
            case "1":
                budget.addIncome();
                break;
            case "2":
                budget.addPurchase();
                break;
            case "3":
                budget.listPurchases();
                break;
            case "4":
                budget.showBalance();
                break;
            case "0":
                budget.exit();
                break;
            default:
                System.out.println("Wrong operation");
                System.out.println();
        }
    }

}
