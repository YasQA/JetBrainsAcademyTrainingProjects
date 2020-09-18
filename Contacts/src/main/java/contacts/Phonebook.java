package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class Phonebook implements Serializable {
    private static final long serialVersionUID = 8L;

    ArrayList<Contact> contactList = new ArrayList<>();
    boolean isON = true;
    transient boolean workWithFile = false;

    transient Menu menu = new Menu(this);

    private Contact contact;
    private transient final ContactFactory personFactory = new ContactPersonFactory();
    private transient final ContactFactory organizationFactory = new ContactOrganizationFactory();

    public void addContact(String type) {
        if ("person".equals(type)) {
            addContactPerson();
        } else if ("organization".equals(type)) {
            addContactOrganization();
        } else {
            System.out.println("Wrong contact type!");
        }
        if (workWithFile) {
            SerializationUtils.savePhonebook(contactList, "phonebook.db");
        }
        System.out.println();
    }

    public void addContactPerson() {
        contact = personFactory.createContact();
        contactList.add(contact);
        System.out.println("A record added.");
    }

    public void addContactOrganization() {
        contact = organizationFactory.createContact();
        contactList.add(contact);
        System.out.println("A record added.");
    }

    public void removeContact(int contactNumber) {
        contactList.remove(contactList.get(contactNumber - 1));
        if (workWithFile) {
            SerializationUtils.savePhonebook(contactList, "phonebook.db");
        }
        System.out.println("The record removed!");
    }

    public void editContact(int index) {
        Contact contactToEdit = contactList.get(index - 1);
        List<String> editableFields = contactToEdit.returnEditableFields();
        String listOfFields = String.join(", ", editableFields);

        System.out.print("Select a field (" + listOfFields + "): ");
        String field = Main.sc.nextLine();

        if (!editableFields.contains(field)) {
            System.out.println("Wrong field specified!");
        } else {
            System.out.print("Enter " + field + ": ");
            String value = Main.sc.nextLine();
            contactToEdit.editField(field, value);
            contactToEdit.timeEdited.setTimeEdited(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
            if (workWithFile) {
                SerializationUtils.savePhonebook(contactList, "phonebook.db");
            }
            System.out.println("Saved");
        }
    }

    public int countContacts() {
        return contactList.size();
    }

    public void countContactsToString() {
        System.out.println("The Phone Book has " + countContacts() + " records");
        System.out.println();
    }

    public void getContactInfo(List<Contact> contactList, int contactNumber) {
        int numberOfContacts = countContacts();
        if (contactNumber > 0 & contactNumber <= numberOfContacts) {
            showContactInfo(contactList, contactNumber);
            System.out.println();
        } else {
            System.out.println("Wrong number!");
        }
    }

    public void showContactInfo(List<Contact> contactList, int i) {
        Contact contact = contactList.get(i - 1);
        System.out.println(contact.toString());
    }

    public void listPhonebook() {
        if (contactList.size() == 0) {
            System.out.println("The Phone Book has 0 records.");
        } else {
            listContacts(contactList);
            menu.listMenu();
        }
        System.out.println();
    }

    public void listSearchResults(List<Contact> searchResultsList) {
        System.out.println("Found " + searchResultsList.size() + " results:");
        listContacts(searchResultsList);
    }

    private void listContacts(List<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            System.out.println((i + 1) + ". " + (contact.getFieldValue("name") + " "
                    + contact.getFieldValue("surname")).trim());
        }
        System.out.println();
    }

    public void searchPhonebook() {
        System.out.print("Enter search query: ");
        String searchString = Main.sc.nextLine();
        List<Contact> searchResultsList = SearchUtils.searchContacts(contactList, searchString);
        if (searchResultsList.size() == 0) {
            System.out.println("Search result is empty, try another parameters");
            System.out.println();
        } else {
            listSearchResults(searchResultsList);
            menu.searchMenu(searchResultsList);
        }
    }

    public void exit() {
        isON = false;
        System.out.println();
    }
}