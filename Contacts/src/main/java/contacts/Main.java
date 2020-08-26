package contacts;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        while (phonebook.isON) {
            phonebook.menu.displayMenu();
            String action = sc.nextLine();
            phonebook.menu.actWithMenu(action);
        }
        sc.close();
    }
}