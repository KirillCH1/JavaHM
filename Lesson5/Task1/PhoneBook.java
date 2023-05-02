import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        ArrayList<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public ArrayList<String> get(String name) {
        return phoneBook.get(name);
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }


}
