package contacts;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        if (args.length == 2 && "open".equals(args[0])) {
            File file = new File(args[1]);
            if (file.isFile()) {
                phonebook.contactList = SerializationUtils.loadPhonebook(args[1]);
                phonebook.workWithFile = true;
            } else {
                try {
                    file.createNewFile();
                    phonebook.workWithFile = true;
                } catch (IOException e) {
                    System.out.println("Cannot create file specified");
                }
            }
        }

        while (phonebook.isON) {
            phonebook.menu.displayMainMenu();
            String action = sc.nextLine();
            phonebook.menu.actWithMainMenu(action);
        }
        sc.close();
    }
}