package Srikanth;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.logging.Logger;

public class DaoOperation {
    Connection cn;
    Student student;
    Address address;

    public DaoOperation() {
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AISHWARYA", "aishu6783");
            System.out.println("connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void insert(Student student) {
        try {
            PreparedStatement preparedStatement = cn.prepareStatement("insert into student values(?,?,?,?)");
            preparedStatement.setInt(1, student.getReg_num());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getStu_name());
            preparedStatement.setString(4, student.getEmail());
            int x = preparedStatement.executeUpdate();
            for(Address address : student.getAddresses()){
                String query2 = "insert into addressofstudent values(sequence_add.nextval,?,?,?,?,?)";
                preparedStatement = cn.prepareStatement(query2);
                //preparedStatement.setInt(1, c_add_id);
                preparedStatement.setInt(1, address.getDoor_num());
                preparedStatement.setString(2, address.getTown());
                preparedStatement.setString(3, address.getCity());
                preparedStatement.setInt(4, address.getPincode());
                preparedStatement.setString(5, address.getType());
                int y = preparedStatement.executeUpdate();

                String query3 = "insert into mapper values(?,sequence_add.currval)";
                preparedStatement = cn.prepareStatement(query3);
                preparedStatement.setInt(1, student.getReg_num());
                int z = preparedStatement.executeUpdate();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
