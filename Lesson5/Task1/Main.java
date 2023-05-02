
/*
    Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
*/


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иван", "+7987654321");
        phoneBook.add("Иван", "+7981234564");
        phoneBook.add("Мария", "+7287216362");

        ArrayList<String> johnPhones = phoneBook.get("Иван");
        System.out.println(johnPhones);

        phoneBook.remove("Иван");

        ArrayList<String> maryPhones = phoneBook.get("Мария");
        System.out.println(maryPhones);
    }
}
