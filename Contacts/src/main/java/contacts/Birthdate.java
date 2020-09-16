package contacts;

import java.io.Serializable;

class Birthdate implements Serializable {
    private String birthdate;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        if (birthdate == null || "\n".equals(birthdate) || "".equals(birthdate)) {
            System.out.println("Bad birth date!");
            this.birthdate = "[no data]";
        } else {
            this.birthdate = birthdate;
        }
    }

    @Override
    public String toString() {
        return birthdate;
    }
}