package behaviors;

import entities.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCSV {
    public static void write(ArrayList<Contact> rows) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contacts.csv"))) {
            bw.write("Name");
            bw.write(",");
            bw.write("DateOfBirth");
            bw.write(",");
            bw.write("Gender");
            bw.write(",");
            bw.write("PhoneNumber");
            bw.write(",");
            bw.write("Address");
            bw.write(",");
            bw.write("Group");
            bw.write(",");
            bw.write("Email");
            bw.write(",");
            bw.write("Facebook");
            bw.newLine();
            for (Contact rowData : rows) {
                bw.write(rowData.toCSVFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void read(){
        try {
            File file = new File("contacts.csv");
            if (!file.isFile()) {
                file.createNewFile();
            }
            BufferedReader bir = new BufferedReader(new FileReader("contacts.csv"));
            String row = bir.readLine();
            while (row != null) {
                row = bir.readLine();
                String[] data = row.split(",");
                Contact c = new Contact();
                c.setName(data[0]);
                c.setDateOfBirth(data[1]);
                c.setGender(data[2]);
                c.setPhoneNumber(Long.parseLong(data[3]));
                c.setAddress(data[4]);
                c.setGroup(data[5]);
                c.setEmail(data[6]);
                c.setFacebook(data[7]);
                ContactManagement.contacts.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
