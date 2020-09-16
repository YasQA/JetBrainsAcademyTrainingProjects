package contacts;

import java.io.Serializable;

class PersonSurname implements Surname, Serializable {
    private String surname;

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String toString() {
        return surname;
    }
}