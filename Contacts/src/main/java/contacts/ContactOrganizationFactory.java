package contacts;

class ContactOrganizationFactory implements ContactFactory {
    @Override
    public Contact createContact() {
        OrganizationFieldsFactory organizationFieldsFactory = new OrganizationFieldsFactory();
        return new ContactOrganization(organizationFieldsFactory);
    }
}