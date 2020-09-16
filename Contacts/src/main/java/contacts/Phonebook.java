package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class Phonebook implements Serializable {
    private static final long serialVersionUID = 7L;

    ArrayList<Contact> phonebookContactList = new ArrayList<>();
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
            SerializationUtils.savePhonebook(phonebookContactList, "phonebook.db");
        }
        System.out.println();
    }

    public void addContactPerson() {
        contact = personFactory.createContact();
        phonebookContactList.add(contact);
        System.out.println("A record added.");
    }

    public void addContactOrganization() {
        contact = organizationFactory.createContact();
        phonebookContactList.add(contact);
        System.out.println("A record added.");
    }

    public void removeContact(int contactNumber) {
        phonebookContactList.remove(phonebookContactList.get(contactNumber - 1));
        if (workWithFile) {
            SerializationUtils.savePhonebook(phonebookContactList, "phonebook.db");
        }
        System.out.println("The record removed!");
    }

    public void editContact(int index) {
        Contact contactToEdit = phonebookContactList.get(index - 1);
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
                SerializationUtils.savePhonebook(phonebookContactList, "phonebook.db");
            }
            System.out.println("Saved");
        }
    }

    public int countContacts() {
        return phonebookContactList.size();
    }

    public void countContactsString() {
        System.out.println("The Phone Book has " + countContacts() + " records");
        System.out.println();
    }

    public void getContactInfo(int contactNumber) {
        int numberOfContacts = countContacts();
        if (contactNumber > 0 & contactNumber <= numberOfContacts) {
            showContactInfo(contactNumber);
            System.out.println();
        } else {
            System.out.println("Wrong number!");
        }
    }

    public void showContactInfo(int i) {
        Contact contact = phonebookContactList.get(i - 1);
        System.out.println(contact.toString());
    }

    public void listPhonebook() {
        if (phonebookContactList.size() == 0) {
            System.out.println("The Phone Book has 0 records.");
        } else {
            for (int i = 1; i <= countContacts(); i++) {
                Contact contact = phonebookContactList.get(i - 1);
                System.out.println(i + ". " + (contact.getFieldValue("name") + " " + contact.getFieldValue("surname")).trim());
            }
            System.out.println();
            menu.listMenu();
        }
        System.out.println();
    }

    public void exit() {
        isON = false;
        System.out.println();
    }
}