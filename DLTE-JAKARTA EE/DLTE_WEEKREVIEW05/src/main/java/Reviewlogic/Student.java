package Reviewlogic;

import Week5review.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student extends Week5review.Student {

    private int regno;
    private String  name;
    private String email;
    private int age;


    public Student(int dbreg_no, String dbName, String dbEmail, int dbAge, List<Address> address) {
    }
}
