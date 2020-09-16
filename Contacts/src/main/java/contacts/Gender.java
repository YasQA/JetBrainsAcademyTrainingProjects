package contacts;

import java.io.Serializable;

class Gender implements Serializable {
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if ("M".equals(gender) || "F".equals(gender)) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }

    @Override
    public String toString() {
        return gender;
    }
}