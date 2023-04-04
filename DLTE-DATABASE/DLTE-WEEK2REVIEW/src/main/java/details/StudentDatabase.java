package details;
import org.example.App;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class StudentDatabase implements StudentDatabaseInterface {

    Scanner scanner = new Scanner(System.in);
    Connection connection;
    PreparedStatement preparedStatement;

    StudentDatabase() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        connection = DriverManager.getConnection(oracleUrl, "AISHWARYA", "aishu6783");
        preparedStatement = connection.prepareStatement("alter session set current_schema=AISHWARYA");
        preparedStatement.executeQuery();
        System.out.println("database Connected");
    }

    //File file = new File("transacc.txt");
    void insertData() throws IOException, SQLException {
        Scanner scannerObject = new Scanner(System.in);
        int reg_num;
        int age;
        int door_num;
        String pincode;
        String stu_name, email;
        String  town, city;

        System.out.println("enter reg num");
        reg_num = scannerObject.nextInt();

        System.out.println("enter age");
        age = scannerObject.nextInt();

        System.out.println("name");
        stu_name = scannerObject.next();
        System.out.println("email");
        email = scannerObject.next();
        System.out.println("door_num");
        door_num = scannerObject.nextInt();
        System.out.println("town");
        town = scannerObject.next();
        System.out.println("city");
        city = scannerObject.next();
        System.out.println("pincode");
        pincode = scannerObject.next();
        System.out.println(pincode);

        StudentDet obj = new StudentDet(reg_num, age, stu_name, email,door_num, town, city, pincode);
    System.out.println(obj);
        insertDatabase(obj);
        /*writing into file
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(obj);
        oos.close();
        fos.close();
    }
    void displayData() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);
        //Reading the data from the file
        System.out.println(ois.readObject());
        ois.close();
        fis.close();

    }*/
    }

    @Override
    public void displayData() throws SQLException {
        preparedStatement = connection.prepareStatement("select * from StudentDetails1, addressofstudents where StudentDetails1.add_id=addressofstudents.add_id");
        ResultSet res = preparedStatement.executeQuery();
        while (res.next()) {
            System.out.println(res.getInt("reg_num") + " " + res.getString("stu_name") + " " + res.getInt("age") + " " + res.getString("email") + " " + res.getInt("door_no") + " " + res.getString("town") + " " + res.getString("city") + " " + res.getString("pincode"));
        }
    }

    @Override
    public void insertDatabase(StudentDet student) throws SQLException {

        preparedStatement = connection.prepareStatement("insert into StudentDetails1 values(?,?,?,?,address_seq.nextval)");
        preparedStatement.setInt(1, student.getReg_num());

        preparedStatement.setString(2, student.getStu_name());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(4, student.getEmail());
        int varA = preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("insert into addressofstudents values(address_seq.currval,?,?,?,?)");
        preparedStatement.setInt(1, student.getDoor_num());
        preparedStatement.setString(2, student.getTown());
        preparedStatement.setString(3, student.getCity());
        preparedStatement.setString(4, student.getPincode());
        int varB = preparedStatement.executeUpdate();
//        if (varA > 0) {
//            System.out.println("inserted");
//        } else {
//            System.out.println("unsuccessfull");
//        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase obj1 = new StudentDatabase();
        while (true) {
            System.out.println("1.display\n2.insert\n3.exit\nEnter your choice:");
            switch (scanner.nextInt()) {
                case 1:
                    obj1.displayData();
                    break;
                case 2:
                    obj1.insertData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}