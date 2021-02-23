package behaviors;

import entities.Contact;

import java.net.Inet4Address;
import java.util.*;

public class Menus {
    static Scanner sc = new Scanner(System.in);

    private Menus() {
    }

    private static class MenusHelper {
        private static final Menus INSTANCE = new Menus();
    }

    public static Menus getInstance() {
        return MenusHelper.INSTANCE;
    }

    public Contact getContactInfo() {
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh");
        String date = sc.nextLine();
        System.out.println("Nhập số điện thoại:");
        long number = Long.parseLong(sc.nextLine());
        System.out.println("Nhập nhóm");
        String group = sc.nextLine();
        System.out.println("Nhập giới tính");
        String gender = sc.nextLine();
        System.out.println("Nhập địa chỉ");
        String add = sc.nextLine();
        System.out.println("Nhập email");
        String email = sc.nextLine();
        System.out.println("Nhập facebook");
        String facebook = sc.nextLine();
        return new Contact(name, group, number, gender, add, date, email, facebook);
    }

    public Contact getContactChosen(ArrayList<Contact> contactsShort) {
        System.out.println("Bạn chọn danh bạ nào?: ");
        for (int i = 1; i <= contactsShort.size(); i++) {
            System.out.println(i + ") " + contactsShort.get(i - 1));
        }
        int choice = Integer.parseInt(sc.nextLine());
        return contactsShort.get(choice - 1);
    }
}
