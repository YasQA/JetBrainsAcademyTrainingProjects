package contacts;

class Menu {
    Phonebook phonebook;

    public Menu(Phonebook phonebook) {
        this.phonebook = phonebook;
    }

    public void displayMenu() {
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
    }

    public void actWithMenu(String menuItem) {
        switch (menuItem) {
            case "add":
                System.out.print("Enter the type (person, organization): ");
                String type = Main.sc.nextLine();
                if ("person".equals(type)) {
                    phonebook.addContactPerson();
                } else if ("organization".equals(type)) {
                    phonebook.addContactOrganization();
                } else {
                    System.out.println("Wrong contact type!");
                }
                System.out.println();
                break;
            case "remove":
                phonebook.removeContact();
                System.out.println();
                break;
            case "edit":
                phonebook.editContact();
                System.out.println();
                break;
            case "count":
                phonebook.countContactsString();
                System.out.println();
                break;
            case "info":
                phonebook.getContactInfo();
                System.out.println();
                break;
            case "exit":
                phonebook.exit();
                System.out.println();
                break;
            default:
                System.out.println("Wrong operation");
                System.out.println();
        }
    }
}
