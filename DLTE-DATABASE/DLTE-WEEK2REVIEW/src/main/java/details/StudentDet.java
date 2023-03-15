package details;

import java.io.Serializable;

public class StudentDet implements Serializable {
    private long reg_num;
    private int age;
    private String stu_name;
    private String email;
    private String adress;
    private int door_num;
    private String town;
    private String city;
    private String pincode;

    public StudentDet(Integer reg_num, Integer age, String stu_name, String email, String adress, Integer door_num, String town, String city, Integer pincode) {
    }

    public long getReg_num() {
        return reg_num;
    }

    public void setReg_num(long reg_num) {
        this.reg_num = reg_num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getDoor_num() {
        return door_num;
    }

    public void setDoor_num(int door_num) {
        this.door_num = door_num;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "StudentDet{" +
                "reg_num=" + reg_num +
                ", age=" + age +
                ", stu_name='" + stu_name + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", door_num=" + door_num +
                ", town='" + town + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}


