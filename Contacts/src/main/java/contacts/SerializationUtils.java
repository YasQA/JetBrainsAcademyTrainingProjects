package contacts;

import java.io.*;
import java.util.ArrayList;

class SerializationUtils {

    public static void savePhonebook(ArrayList<Contact> сontactList, String filename) {
        try {
            SerializationUtils.serialize(сontactList, filename);
        } catch (IOException e) {
            System.out.println("Cannot save Phonebook to the file specified");
            e.printStackTrace();
        }
    }

    public static ArrayList<Contact>  loadPhonebook(String filename) {
        ArrayList<Contact> contactList = new ArrayList<>();
        try {
            contactList = (ArrayList<Contact>) SerializationUtils.deserialize(filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load Phonebook from the file specified");
            e.printStackTrace();
        }
        return contactList;
    }

    /**
     * Serialize the given object to the file
     */
    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }

    /**
     * Deserialize to an object from the file
     */
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}