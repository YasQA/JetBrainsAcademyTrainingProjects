package contacts;

import java.io.Serializable;
import java.util.List;

abstract class Contact implements Serializable {
    Name name;
    PhoneNumberGeneral phoneNumber;
    TimeCreated timeCreated;
    TimeEdited timeEdited;

    public abstract String toString();

    public abstract List<String> returnEditableFields();

    public abstract void editField(String fieldToEdit, String value);

    public abstract String getFieldValue(String field);
}