import java.util.*;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person contact) {
        contacts.add(contact);
    }

    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy) {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                String s1 = "";
                String s2 = "";

                if (sortBy == 0) {
                    s1 = contacts.get(j).getFirstName();
                    s2 = contacts.get(j + 1).getFirstName();
                } else if (sortBy == 1) {
                    s1 = contacts.get(j).getLastName();
                    s2 = contacts.get(j + 1).getLastName();
                } else if (sortBy == 2) {
                    s1 = contacts.get(j).getPhoneNumber();
                    s2 = contacts.get(j + 1).getPhoneNumber();
                }

                if (s1.compareToIgnoreCase(s2) > 0) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }
}
