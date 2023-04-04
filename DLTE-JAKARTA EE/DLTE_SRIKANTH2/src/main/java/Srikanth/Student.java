package Srikanth;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data

@NoArgsConstructor
public class Student {
    private int reg_num;
    private int age;
    private String stu_name;
    private String email;
    private ArrayList<Address> addresses = new ArrayList<>();

    public Student(int reg_num, int age, String stu_name, String email) {
        this.reg_num = reg_num;
        this.age = age;
        this.stu_name = stu_name;
        this.email = email;
    }
}
