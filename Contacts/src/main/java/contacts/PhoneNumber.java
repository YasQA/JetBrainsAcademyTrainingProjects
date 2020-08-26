package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PhoneNumber implements PhoneNumberGeneral {
    private String phoneNumber;

    @Override
    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "";
        }
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

    public static boolean isValidPhoneNumber(String number) {
        String regexp = "^(\\+?\\([a-zA-Z0-9]+\\)([ -][a-zA-Z0-9]{2,})*$)" +
                "|^(\\+?[a-zA-Z0-9]+[ -]\\([a-zA-Z0-9]{2,}\\)([ -][a-zA-Z0-9]{2,})*$)" +
                "|^(\\+?[a-zA-Z0-9]+([ -][a-zA-Z0-9]{2,})*)$";// +

        Pattern javaPattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(number);
        return matcher.find();
    }
}