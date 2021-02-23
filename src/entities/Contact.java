package entities;

public class Contact {
    private String name;
    private String group;
    private long phoneNumber;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;
    private String facebook;

    public Contact() {
    }

    public Contact(String name, String group, long phoneNumber, String gender, String address, String dateOfBirth, String email, String facebook) {
        this.name = name;
        this.group = group;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.facebook = facebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String toCSVFormat() {
        return name + "," + dateOfBirth + "," + gender + "," + phoneNumber + "," + address + "," + group + "," + email + "," + facebook;
    }

    @Override
    public String toString() {
        return "Danh bạ{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }
}
