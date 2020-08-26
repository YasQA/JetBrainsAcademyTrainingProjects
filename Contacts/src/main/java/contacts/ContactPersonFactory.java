package contacts;

class ContactPersonFactory implements ContactFactory {
    @Override
    public Contact createContact() {
        PersonFieldsFactory personFieldsFactory = new PersonFieldsFactory();
        return new ContactPerson(personFieldsFactory);
    }
}