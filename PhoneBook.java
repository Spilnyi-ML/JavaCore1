package homeWorkLesson4;

import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, Integer> phoneBook = new HashMap<>();

    public HashMap<String, Integer> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(HashMap<String, Integer> phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", 1234567);
        phoneBook.add("Petrov", 7654321);
        System.out.println(phoneBook);

        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("Ivanov"));

    }

    public void add(String female, int phoneNumber){
        phoneBook.put(female, phoneNumber);
    }

    public Integer get(String female) {
        return phoneBook.get(female);
    }
}