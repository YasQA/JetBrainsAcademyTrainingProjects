package budget;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String fileName = "purchases.txt";

    public static void main(String[] args) {
        Budget budget = new Budget();

        while (budget.isON) {
            budget.menu.displayMainMenu();
            String action = sc.nextLine();
            budget.menu.actWithMainMenu(action);
        }
        sc.close();
    }
}
