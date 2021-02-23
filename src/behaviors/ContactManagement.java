package behaviors;

import entities.Contact;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagement {
    public static ArrayList<Contact> contacts = new ArrayList<>();

    private ContactManagement() {}

    public static ContactManagement getInstance() {
        return ContactManagementHelper.INSTANCE;
    }
    private static class ContactManagementHelper {
        private static final ContactManagement INSTANCE = new ContactManagement();
    }

    public void add (Contact contact) {
        contacts.add(contact);
    }
    public void remove (Contact contact) {
        contacts.remove(contact);
    }
    public void show () {
        for (Contact contact:contacts) {
            System.out.println(contact.toString());
        }
    }
    public void update (Contact oldContact, Contact newContact) {
        oldContact.setName(newContact.getName());
        oldContact.setAddress(newContact.getAddress());
        oldContact.setDateOfBirth(newContact.getDateOfBirth());
        oldContact.setEmail(newContact.getEmail());
        oldContact.setGender(newContact.getGender());
        oldContact.setGroup(newContact.getGroup());
        oldContact.setPhoneNumber(newContact.getPhoneNumber());
        oldContact.setFacebook(newContact.getFacebook());
    }
    public ArrayList<Contact> searchContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên để tìm kiếm: ");
        String name = sc.nextLine();
        ArrayList<Contact> contactsFound = new ArrayList<>();
        for (Contact c:contacts) {
            if (c.getName().equals(name)) {
                contactsFound.add(c);
            }
        }
        return contactsFound;
    }
}
