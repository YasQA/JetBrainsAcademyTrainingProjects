package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class ContactPerson extends Contact implements Serializable {
    Surname surname;
    Birthdate birthdate;
    Gender gender;

    ContactPerson(PersonFieldsFactory fieldsFactory) {
        name = fieldsFactory.createName();
        surname = fieldsFactory.createSurname();
        birthdate = fieldsFactory.createBirthdate();
        gender = fieldsFactory.createGender();
        phoneNumber = fieldsFactory.createNumber();
        timeCreated = fieldsFactory.createTimeCreated();
        timeEdited = fieldsFactory.createTimeEdited();
    }

    @Override
    public String toString() {
        return "Name: " + name.toString() + "\n"
                + "Surname: " + surname.toString() + "\n"
                + "Birth date: " + birthdate.toString() + "\n"
                + "Gender: " + gender.toString() + "\n"
                + "Number: " + phoneNumber.toString() + "\n"
                + "Time created: " + timeCreated.toString() + "\n"
                + "Time last edit: " + timeEdited.toString();
    }

    @Override
    public String fieldsString() {
        return name.toString() + " "
                + surname.toString() + " "
                + birthdate.toString() + " "
                + gender.toString() + " "
                + phoneNumber.toString();
    }

    @Override
    public List<String> returnEditableFields() {
        List<String> fieldsList = new ArrayList<>();
        fieldsList.add("name");
        fieldsList.add("surname");
        fieldsList.add("birth");
        fieldsList.add("gender");
        fieldsList.add("number");
        return fieldsList;
    }

    @Override
    public void editField(String fieldToEdit, String value) {
        switch (fieldToEdit) {
            case "name":
                name.setName(value);
                break;
            case "surname":
                surname.setSurname(value);
                break;
            case "birthday":
                birthdate.setBirthdate(value);
                break;
            case "gender":
                gender.setGender(value);
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
            case "surname":
                return surname.getSurname();
            case "birthday":
                return birthdate.getBirthdate();
            case "gender":
                return gender.getGender();
            case "number":
                return phoneNumber.getPhoneNumber();
            default:
                return "Wrong field name!";
        }
    }
}
