package contacts;

interface ContactFieldsFactory {
    Name createName();
    PhoneNumberGeneral createNumber();
}