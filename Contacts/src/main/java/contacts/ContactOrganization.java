package contacts;

class ContactOrganization extends Contact {
    Address address;

    ContactOrganization(OrganizationFieldsFactory fieldsFactory) {
        isPerson = fieldsFactory.createIsPersonFalse();
        name = fieldsFactory.createName();
        address = fieldsFactory.createAddress();
        phoneNumber = fieldsFactory.createNumber();
        timeCreated = fieldsFactory.createTimeCreated();
        timeEdited = fieldsFactory.createTimeEdited();
    }

    @Override
    public String toString() {
        return "Organization name: " + name.toString() + "\n"
                + "Address: " + address.toString() + "\n"
                + "Number: " + phoneNumber.toString() + "\n"
                + "Time created: " + timeCreated.toString() + "\n"
                + "Time last edit: " + timeEdited.toString();
    }
}