package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchUtils {

    public static List<Contact> searchContacts(List<Contact> contacts, String searchString) {
        Pattern pattern = Pattern.compile(searchString, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        List<Contact> searchResults = new ArrayList<>();

        for (Contact contact : contacts) {
            matcher = pattern.matcher(contact.fieldsString());
            if (matcher.find()) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }
}
