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
    Connection con;
    PreparedStatement preparedStatement;

    StudentDatabase() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        con = DriverManager.getConnection(oracleUrl, "system", "aishu6783");
        preparedStatement = con.prepareStatement("alter session set current_schema=AISHWARYA");
        preparedStatement.executeQuery();
        System.out.println("Connected");
    }

    //File file = new File("transacc.txt");
    void insertData() throws IOException, SQLException {
        Scanner scannerObject = new Scanner(System.in);
        Integer reg_num, age, door_num, pincode;
        String stu_name, email;
        String adress, town, city;

        System.out.println("enter reg num");
        reg_num = scannerObject.nextInt();
        System.out.println("enter age");
        age = scannerObject.nextInt();
        System.out.println("name");
        stu_name = scannerObject.next();
        System.out.println("email");
        email = scannerObject.next();
        System.out.println("adress");
        adress = scannerObject.next();
        System.out.println("door_num");
        door_num = scannerObject.nextInt();
        System.out.println("town");
        town = scannerObject.next();
        System.out.println("city");
        city = scannerObject.next();
        System.out.println("pincode");
        pincode = scannerObject.nextInt();


        StudentDet obj = new StudentDet(reg_num, age, stu_name, email, adress, door_num, town, city, pincode);

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
        preparedStatement = con.prepareStatement("select * from StudentDetails1,address where address_id=add_id");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("reg_no") + " " + rs.getString("name") + " " + rs.getInt("age") + " " + rs.getString("email") + " " + rs.getInt("door_no") + " " + rs.getString("town") + " " + rs.getString("city") + " " + rs.getInt("pincode"));
        }
    }

    @Override
    public void insertDatabase(StudentDet student) throws SQLException {
        preparedStatement = con.prepareStatement("insert into StudentDetails values(sequenc.NEXTVAL,?,?,?,?)");
        preparedStatement.setInt(1, (int) student.getReg_num());
        preparedStatement.setString(2, student.getStu_name());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(4, student.getEmail());
        int varA = preparedStatement.executeUpdate();
        preparedStatement = con.prepareStatement("insert into address values(sequence1.NEXTVAL,?,?,?,?)");
        preparedStatement.setInt(1, student.getDoor_num());
        preparedStatement.setString(2, student.getTown());
        preparedStatement.setString(3, student.getCity());
        preparedStatement.setString(4, student.getPincode());
        int varB = preparedStatement.executeUpdate();
        if (varA > 0 && varB > 0) {
            System.out.println("inserted");
        } else {
            System.out.println("unsuccessfull");
        }
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
                    System.out.println("Invalid choice...enter properly");
            }
        }
    }
}