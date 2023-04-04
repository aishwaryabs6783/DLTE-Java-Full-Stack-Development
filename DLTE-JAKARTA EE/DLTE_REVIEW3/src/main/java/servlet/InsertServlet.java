package servlet;

import oracle.jdbc.datasource.OracleDataSource;
import oracle.jdbc.driver.OracleDriver;
import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertServlet", value = "/insert")
public class InsertServlet extends HttpServlet {

    private Student student;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String reg1_num=request.getParameter("reg_num");
        String age1=request.getParameter("age");
        String stu1_name=request.getParameter("stu_name");
        String email1=request.getParameter("email");

        int reg_num=Integer.parseInt(reg1_num);
        int age=Integer.parseInt(age1);


//        String add1_id=request.getParameter("p_add_id");
        String door1_num=request.getParameter("p_door_num");
        String town1=request.getParameter("p_town");
        String city1=request.getParameter("p_City");
        String pincode1=request.getParameter("p_Pincode");
//        int p_add_id=Integer.parseInt(add1_id);
        int p_door_num=Integer.parseInt(door1_num);


//        String add2_id=request.getParameter("c_add_id");
        String door2_num=request.getParameter("c_door_num");
        String town2=request.getParameter("c_town");
        String city2=request.getParameter("c_City");
        String pincode2=request.getParameter("c_Pincode");
//        int c_add_id=Integer.parseInt(add1_id);
        int c_door_num=Integer.parseInt(door1_num);


        logger.log(Level.INFO,reg_num+","+age+","+stu1_name+","+email1);


        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AISHWARYA", "aishu6783");
            String query="insert into student values(?,?,?,?)";
            PreparedStatement preparedStatement=cn.prepareStatement(query);
            preparedStatement.setLong(1,reg_num);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,stu1_name);
            preparedStatement.setString(4,email1);
            int x = preparedStatement.executeUpdate();

            String query2="insert into addressofstudent values(sequence_add.nextval,?,?,?,?,?)";
            preparedStatement=cn.prepareStatement(query2);
            //preparedStatement.setInt(1, c_add_id);
            preparedStatement.setInt(1, c_door_num);
            preparedStatement.setString(2, town2);
            preparedStatement.setString(3, city2);
            preparedStatement.setString(4, pincode2);
            preparedStatement.setString(5, "current");
            int y = preparedStatement.executeUpdate();

            String query3="insert into mapper values(?,sequence_add.currval)";
            preparedStatement=cn.prepareStatement(query3);
            preparedStatement.setInt(1, reg_num);
            int z = preparedStatement.executeUpdate();

            String query4="insert into addressofstudent values(sequence_add.nextval,?,?,?,?,?)";
            preparedStatement=cn.prepareStatement(query4);
            //preparedStatement.setInt(1, p_add_id);
            preparedStatement.setInt(1, p_door_num);
            preparedStatement.setString(2, town1);
            preparedStatement.setString(3, city1);
            preparedStatement.setString(4, pincode1);
            preparedStatement.setString(5, "permanent");
            int a = preparedStatement.executeUpdate();

            String query5="insert into mapper values(?,sequence_add.currval)";
            preparedStatement=cn.prepareStatement(query3);
            preparedStatement.setInt(1, reg_num);
            int b = preparedStatement.executeUpdate();



// preparedStatement.setInt(5,sq_no.CURRVAL);

            if (x > 0 && y > 0 && z>0 && a>0 && b>0) {
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                logger.log(Level.INFO,"Insertion successful");
                dispatcher.forward(request,response);
            } else {
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                logger.log(Level.INFO,"Insertion unsuccessful");
                dispatcher.forward(request,response);
            }
            ResultSet resultSet = null;
//            if (resultSet.next()) {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("dash.jsp");
//                logger.log(Level.INFO, "Authenticated");
////System.out.println("Passed "+resultSet.getString("banker_name"));
//                request.setAttribute("banker", resultSet.getString("banker_name"));
//                dispatcher.forward(request, response);
//            } else {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//                logger.log(Level.WARNING, "Not Authenticated");
//                dispatcher.forward(request, response);
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}