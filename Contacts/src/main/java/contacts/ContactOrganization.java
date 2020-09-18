package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class ContactOrganization extends Contact implements Serializable {
    Address address;

    ContactOrganization(OrganizationFieldsFactory fieldsFactory) {
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

    @Override
    public String fieldsString() {
        return name.toString() + " "
                + address.toString() + " "
                + phoneNumber.toString();
    }

    @Override
    public List<String> returnEditableFields() {
        List<String> fieldsList = new ArrayList<>();
        fieldsList.add("name");
        fieldsList.add("address");
        fieldsList.add("number");
        return fieldsList;
    }

    @Override
    public void editField(String fieldToEdit, String value) {
        switch (fieldToEdit){
            case "name":
                name.setName(value);
                break;
            case "address":
                address.setAddress(value);
                break;
            case "number":
                phoneNumber.setPhoneNumber(value);
                break;
        }
    }

    @Override
    public String getFieldValue(String field) {
        switch (field) {
            case "name":
                return name.getName();
            case "address":
                return address.getAddress();
            case "number":
                return phoneNumber.getPhoneNumber();
            default:
                return "";
        }
    }
}