package budget;

import java.io.*;

class SerializationUtils {

    public static void saveBudget(Budget budget, String filename) {
        try {
            SerializationUtils.serialize(budget, filename);
        } catch (IOException e) {
            System.out.println("Cannot save Budget to the file specified");
            e.printStackTrace();
        }
    }

    public static Budget loadBudget(String filename) {
        Budget budget = new Budget();
        try {
            budget = (Budget) SerializationUtils.deserialize(filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load Budget from the file specified");
            e.printStackTrace();
        }
        return budget;
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