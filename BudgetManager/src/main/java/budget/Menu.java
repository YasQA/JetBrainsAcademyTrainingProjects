package budget;

public class Menu {
    Budget budget;

    static final String MAIN_MENU =
        "1) Add income\n" +
        "2) Add purchase\n" +
        "3) Show list of purchases\n" +
        "4) Balance\n" +
        "5) Save\n" +
        "6) Load\n" +
        "7) Analyze (Sort)\n" +
        "0) Exit";

    static final String ADD_PURCHASE_MENU =
        "1) Food\n" +
        "2) Clothes\n" +
        "3) Entertainment\n" +
        "4) Other\n" +
        "5) Back";

    static final String SHOW_PURCHASE_MENU =
        "1) Food\n" +
        "2) Clothes\n" +
        "3) Entertainment\n" +
        "4) Other\n" +
        "5) All\n" +
        "6) Back";

    static final String SORT_TYPE_SELECTION_MENU =
        "1) Food\n" +
        "2) Clothes\n" +
        "3) Entertainment\n" +
        "4) Other";

    static final String SORT_MENU =
        "1) Sort all purchases\n" +
        "2) Sort by type\n" +
        "3) Sort certain type\n" +
        "4) Back";

    public Menu(Budget budget) {
        this.budget = budget;
    }

    public void displayMainMenu() {
        System.out.println("Choose your action:");
        System.out.println(MAIN_MENU);
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
            case "5":
                budget.save();
                break;
            case "6":
                budget.load();
                break;
            case "7":
                budget.sort();
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
