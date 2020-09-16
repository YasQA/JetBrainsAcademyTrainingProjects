package contacts;

class PersonFieldsFactory implements ContactFieldsFactory {
    @Override
    public Name createName() {
        System.out.print("Enter the name: ");
        String name = Main.sc.nextLine();
        PersonName personName = new PersonName();
        personName.setName(name);
        return personName;
    }

    @Override
    public PhoneNumberGeneral createNumber() {
        System.out.print("Enter the number: ");
        String number = Main.sc.nextLine();
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNumber(number);
        return phoneNumber;
    }

    public Surname createSurname() {
        System.out.print("Enter the surname: ");
        String surname = Main.sc.nextLine();
        PersonSurname personSurname = new PersonSurname();
        personSurname.setSurname(surname);
        return personSurname;
    }

    public Birthdate createBirthdate() {
        System.out.print("Enter the birth date: ");
        String birthdate = Main.sc.nextLine();
        Birthdate personBirthdate = new Birthdate();
        personBirthdate.setBirthdate(birthdate);
        return personBirthdate;
    }

    public Gender createGender() {
        System.out.print("Enter the gender: ");
        String gender = Main.sc.nextLine();
        Gender personGender = new Gender();
        personGender.setGender(gender);
        return personGender;
    }

    public TimeCreated createTimeCreated() {
        return new TimeCreated();
    }

    public TimeEdited createTimeEdited() {
        return new TimeEdited();
    }
}
