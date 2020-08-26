package contacts;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

class Phonebook {
    ArrayList<Contact> phonebookContactList = new ArrayList<>();
    Menu menu = new Menu(this);
    Scanner sc = new Scanner(System.in);
    boolean isON = true;

    Contact contact;
    ContactFactory personFactory = new ContactPersonFactory();
    ContactFactory organizationFactory = new ContactOrganizationFactory();

    public void addContactPerson() {
        contact = personFactory.createContact();
        phonebookContactList.add(contact);
        System.out.println("The record added.");
    }

    public void addContactOrganization() {
        contact = organizationFactory.createContact();
        phonebookContactList.add(contact);
        System.out.println("The record added.");
    }

    public void removeContact() {
        if (countContacts() == 0) {
            System.out.println("No records to remove!");
        } else {
            listPhonebook();
            System.out.println("Select a record: ");
            int contactNumber = Integer.parseInt(sc.nextLine());
            // TODO: check number if exists !!!
            phonebookContactList.remove(phonebookContactList.get(contactNumber - 1));
            System.out.println("The record removed!");
        }
    }

    public void editContact() {
        if (phonebookContactList.size() == 0) {
            System.out.println("No records to edit");
        } else {
            listPhonebook();
            System.out.print("Select a record: ");
            int index = Integer.parseInt(sc.nextLine());

            Contact contactToEdit = phonebookContactList.get(index - 1);

            if (isPerson(contactToEdit)) {
                System.out.print("Select a field (name, surname, birth, gender, number): ");
                String field = sc.nextLine();
                //TODO: check correctness of selected field
                editContactPerson((ContactPerson)contactToEdit, field);
            } else {
                System.out.print("Select a field (organization name, address, number): ");
                String field = sc.nextLine();
                //TODO: check correctness of selected field
                editContactOrganization((ContactOrganization)contactToEdit, field);
            }

            System.out.println("The record updated!");
        }
    }

    public void editContactPerson(ContactPerson contact, String field) {
        switch (field) {
            case "name":
                System.out.print("Enter name: ");
                contact.name.setName(Main.sc.nextLine());
                break;
            case "surname":
                System.out.print("Enter surname: ");
                contact.surname.setSurname(Main.sc.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                contact.phoneNumber.setPhoneNumber(Main.sc.nextLine());
                break;
            case "gender":
                System.out.println("Enter gender: ");
                contact.gender.setGender(Main.sc.nextLine());
                break;
            case "birth":
                System.out.println("Enter birthdate: ");
                contact.birthdate.setBirthdate(Main.sc.nextLine());
                break;
            default:
                System.out.println("Wrong field specified!");
        }
        contact.timeEdited.setTimeEdited(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
    }

    public void editContactOrganization(ContactOrganization contact, String field) {
        switch (field) {
            case "name":
                System.out.print("Enter name: ");
                contact.name.setName(Main.sc.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                contact.phoneNumber.setPhoneNumber(Main.sc.nextLine());
                break;
            case "address":
                System.out.println("Enter address: ");
                contact.address.setAddress(Main.sc.nextLine());
                break;
            default:
                System.out.println("Wrong field specified!");
        }
        contact.timeEdited.setTimeEdited(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
    }

    public int countContacts() {
        return phonebookContactList.size();
    }

    public void countContactsString() {
        System.out.println("The Phone Book has " + countContacts() + " records");
    }

    public void getContactInfo() {
        int numberOfContacts = countContacts();

        if (numberOfContacts == 0) {
            System.out.println("The Phone Book has 0 records.");
        } else {
            listPhonebook();
            System.out.print("Enter index to show info: ");
            int contactNumber = Integer.parseInt(Main.sc.nextLine());
            if (contactNumber > 0 & contactNumber <= numberOfContacts) {
                showContactInfo(contactNumber);
            } else {
                System.out.println("Wrong number");
            }
        }
    }

    public void listPhonebook() {
        for (int i = 1; i <= countContacts(); i++) {
            Contact contact = phonebookContactList.get(i - 1);
            if (isPerson(contact)) {
                System.out.println(i + ". " + contact.name.toString() + " " + ((ContactPerson)contact).surname.toString());
            } else {
                System.out.println(i + ". " + contact.name.toString());
            }
        }
    }

    public boolean isPerson(Contact contact) {
        return contact.isPerson.getIsPerson();
    }

    public void showContactInfo(int i) {
        Contact contact = phonebookContactList.get(i - 1);
        System.out.println(contact.toString());
    }

    public void exit() {
        isON = false;
    }
}