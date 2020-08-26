package contacts;

abstract class Contact {
    IsPerson isPerson;
    Name name;
    //Surname surname;
    PhoneNumberGeneral phoneNumber;
    TimeCreated timeCreated;
    TimeEdited timeEdited;

    public abstract String toString();
}