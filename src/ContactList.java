import java.util.Scanner;
import java.util.ArrayList;

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

                switch (sortBy) {
                    case 0:
                        s1 = contacts.get(j).getFirstName();
                        s2 = contacts.get(j + 1).getFirstName();
                        break;
                    case 1:
                        s1 = contacts.get(j).getLastName();
                        s2 = contacts.get(j + 1).getLastName();
                        break;
                    case 2:
                        s1 = contacts.get(j).getPhoneNumber();
                        s2 = contacts.get(j + 1).getPhoneNumber();
                        break;
                }

                if (s1.compareToIgnoreCase(s2) > 0) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (contact.getLastName().equalsIgnoreCase(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Name");
            System.out.println("3. List All Contacts By Last Name");
            System.out.println("4. List All Contacts By Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By Last Name");
            System.out.println("8. Search By Phone Number");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();

                    System.out.println("Enter 1 to add a Student, or 2 to add a Teacher:");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type == 1) {
                        System.out.println("Enter grade:");
                        int grade = scanner.nextInt();
                        scanner.nextLine();
                        addContact(new Student(firstName, lastName, phoneNumber, grade));
                    } else if (type == 2) {
                        System.out.println("Enter subject:");
                        String subject = scanner.nextLine();
                        addContact(new Teacher(firstName, lastName, phoneNumber, subject));
                    }
                    break;
                case 2:
                    sort(0);
                    printContacts();
                    break;
                case 3:
                    sort(1);
                    printContacts();
                    break;
                case 4:
                    sort(2);
                    printContacts();
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:
                    System.out.println("Enter a first name:");
                    firstName = scanner.nextLine();
                    Person result = searchByFirstName(firstName);
                    if (result != null) {
                        System.out.println(result);
                    } else {
                        System.out.println(firstName + " is not in the list");
                    }
                    break;
                case 7:
                    System.out.println("Enter a last name:");
                    lastName = scanner.nextLine();
                    result = searchByLastName(lastName);
                    if (result != null) {
                        System.out.println(result);
                    } else {
                        System.out.println(lastName + " is not in the list");
                    }
                    break;
                case 8:
                    System.out.println("Enter a phone number:");
                    phoneNumber = scanner.nextLine();
                    result = searchByPhoneNumber(phoneNumber);
                    if (result != null) {
                        System.out.println(result);
                    } else {
                        System.out.println(phoneNumber + " is not in the list");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}
