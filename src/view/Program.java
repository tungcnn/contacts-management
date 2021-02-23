package view;

import behaviors.ContactManagement;
import behaviors.Menus;
import behaviors.ReadWriteCSV;
import entities.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Menus menu = Menus.getInstance();
        ContactManagement cm = ContactManagement.getInstance();
        ArrayList<Contact> contacts;
        do {
            System.out.print("""
                    ===============CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ===============
                    Chọn chức năng theo số để tiếp tục:
                    1) Xem danh sách
                    2) Thêm mới
                    3) Cập nhật
                    4) Xóa
                    5) Tìm kiếm
                    6) Đọc từ file
                    7) Ghi từ file
                    8) Thoát
                    Chọn chức năng: 
                    """);
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Danh bạ:");
                        cm.show();
                        break;
                    case 2:
                        Contact c = menu.getContactInfo();
                        cm.add(c);
                        System.out.println("Đã thêm " + c.toString());
                        break;
                    case 3:
                        contacts = cm.searchContact();
                        if (contacts.size() == 0) {
                            System.out.println("Không tìm thấy danh bạ với tên này");
                        } else {
                            Contact oldC = menu.getContactChosen(contacts);
                            Contact newC = menu.getContactInfo();
                            cm.update(oldC, newC);
                            System.out.println("Đã cập nhật! Thông tin mới: ");
                            System.out.println(oldC.toString());
                        }
                        break;
                    case 4:
                        contacts = cm.searchContact();
                        if (contacts.size() == 0) {
                            System.out.println("Không tìm thấy danh bạ với tên này");
                        } else {
                            contacts = cm.searchContact();
                            Contact removeC = menu.getContactChosen(contacts);
                            cm.remove(removeC);
                            System.out.println("Đã xóa " + removeC.toString());
                        }
                        break;
                    case 5:
                        contacts = cm.searchContact();
                        if (contacts.size() == 0) {
                            System.out.println("Không tìm thấy danh bạ với tên này");
                        } else {
                            System.out.println("Danh bạ tìm dc: ");
                            for (Contact c3 : contacts) {
                                System.out.println(c3.toString());
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Bạn có chắc muốn ghi danh bạ ra file?(Y/N)");
                        String answer1 = sc.nextLine();
                        switch (answer1) {
                            case "Y":
                                ReadWriteCSV.read();
                                System.out.println("Đã cập nhật danh bạ từ file csv.");
                                break;
                            case "N":
                                break;
                            default:
                                System.out.println("Bạn ko bấm Y hoặc N");
                                break;
                        }
                        break;
                    case 7:
                        System.out.println("Bạn có chắc muốn ghi danh bạ ra file?(Y/N)");
                        String answer2 = sc.nextLine();
                        switch (answer2) {
                            case "Y":
                                ReadWriteCSV.write(ContactManagement.contacts);
                                System.out.println("Đã ghi danh bạ ra file csv");
                                break;
                            case "N":
                                break;
                            default:
                                System.out.println("Bạn ko bấm Y hoặc N");
                                break;
                        }
                        break;
                    case 8:
                        System.out.println("Hẹn gặp lại!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Hãy nhập 1 số từ 1 đến 8");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập 1 số");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Bạn chưa chọn đúng số");
            }
        } while (true);
    }
}
