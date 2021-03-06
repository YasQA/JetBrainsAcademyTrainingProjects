package contacts;

import java.util.List;

class Menu {
    Phonebook phonebook;

    public Menu(Phonebook phonebook) {
        this.phonebook = phonebook;
    }

    public void displayMainMenu() {
        System.out.print("[Menu] Enter action (add, list, search, count, exit): ");
    }

    public void actWithMainMenu(String menuItem) {
        switch (menuItem) {
            case "add":
                System.out.print("Enter the type (person, organization): ");
                String type = Main.sc.nextLine();
                phonebook.addContact(type);
                break;
            case "list":
                phonebook.listPhonebook();
                break;
            case "search":
                phonebook.searchPhonebook();
                break;
            case "count":
                phonebook.countContactsToString();
                break;
            case "exit":
                phonebook.exit();
                break;
            default:
                System.out.println("Wrong operation");
                System.out.println();
        }
    }

    public void recordMenu(int contactNumber) {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        String command = Main.sc.nextLine();
        switch (command) {
            case "menu" :
                System.out.println();
                break;
            case "edit":
                phonebook.editContact(contactNumber);
                phonebook.getContactInfo(phonebook.contactList, contactNumber);
                recordMenu(contactNumber);
                break;
            case "delete" :
                phonebook.removeContact(contactNumber);
                break;
        }
    }

    public void listMenu() {
        System.out.print("[list] Enter action ([number], back): ");
        String command = Main.sc.nextLine();
        if ("back".equals(command)) {
            return;
        } else try {
            int contactNumber = Integer.parseInt(command);
            phonebook.getContactInfo(phonebook.contactList, contactNumber);
            recordMenu(contactNumber);
        } catch (NumberFormatException e) {
            System.out.println("Wrong number/command!");
            System.out.println();
        }
    }

    public void searchMenu(List<Contact> searchResultsList) {
        System.out.print("[search] Enter action ([number], back, again): ");
        String command = Main.sc.nextLine();
        if ("back".equals(command)) {
            return;
        } else if ("again".equals(command)) {
            phonebook.searchPhonebook();
        } else try {
            int contactNumber = Integer.parseInt(command);
            phonebook.getContactInfo(searchResultsList, contactNumber);
            recordMenu(contactNumber);
            } catch (NumberFormatException e) {
                System.out.println("Wrong number/command!");
                System.out.println();
        }
    }
}
