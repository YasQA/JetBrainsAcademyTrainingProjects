package contacts;

class ContactPerson extends Contact {
    Surname surname;
    Birthdate birthdate;
    Gender gender;

    ContactPerson(PersonFieldsFactory fieldsFactory) {
        isPerson = fieldsFactory.createIsPersonTrue();
        name = fieldsFactory.createName();
        surname = fieldsFactory.createSurname();
        birthdate = fieldsFactory.createBirthdate();
        gender = fieldsFactory.createGender();
        phoneNumber = fieldsFactory.createNumber(); //General ?
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
}
