package org.example;

import java.io.Serializable;

public class StudentDetails implements Serializable {
    private long reg_num;
    private int age;
    private String name;
    private String email;
    private String address;

    public StudentDetails(long reg_num, int age, String name, String email, String address) {
        this.reg_num = reg_num;
        this.age = age;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "reg_num=" + reg_num +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
