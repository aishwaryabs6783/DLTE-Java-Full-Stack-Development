package ServletPackage;

import Srikanth.Address;
import Srikanth.DaoOperation;
import Srikanth.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertServlet", value = "/insert")
public class InsertServlet extends HttpServlet {

    private Student student;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String reg1_num = request.getParameter("reg_num");
        String age1 = request.getParameter("age");
        String stu1_name = request.getParameter("stu_name");
        String email1 = request.getParameter("email");

        int reg_num = Integer.parseInt(reg1_num);
        int age = Integer.parseInt(age1);


//        String add1_id=request.getParameter("p_add_id");
        String door1_num = request.getParameter("p_door_num");
        String town1 = request.getParameter("p_town");
        String city1 = request.getParameter("p_City");
        String pincode1 = request.getParameter("p_Pincode");
//        int p_add_id=Integer.parseInt(add1_id);
        int p_door_num = Integer.parseInt(door1_num);
        int p_Pincode=Integer.parseInt(pincode1);


//        String add2_id=request.getParameter("c_add_id");
        String door2_num = request.getParameter("c_door_num");
        String town2 = request.getParameter("c_town");
        String city2 = request.getParameter("c_City");
        String pincode2 = request.getParameter("c_Pincode");
//        int c_add_id=Integer.parseInt(add1_id);
        int c_door_num = Integer.parseInt(door1_num);
        int c_Pincode=Integer.parseInt(pincode2);


        logger.log(Level.INFO, reg_num + "," + age + "," + stu1_name + "," + email1);
        Student student = new Student(reg_num,age,stu1_name,email1);
        student.getAddresses().add(new Address(p_door_num,town1,city1,pincode1,"Permanent"));
        student.getAddresses().add(new Address(c_door_num,town2,city2,pincode2,"Current"));

        DaoOperation dbOperations = new DaoOperation();
        dbOperations.insert(student);

        logger.log(Level.INFO, "Insertion Successful");
        RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
        dispatcher.forward(request, response);


    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}