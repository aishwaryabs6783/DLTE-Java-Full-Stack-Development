package Reviewlogic;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "FetchdummyServlet")
public class FetchdummyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student=new Student(123,"aish","aish@gmail.com",21);
        Student student1=new Student(888,"van","van@gmail.com",19);
        ArrayList<Student>list=new ArrayList<>();
        list.add(student);
        list.add(student1);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=response.getWriter();
        Gson gson=new Gson();
        printWriter.write(gson.toJson(list));


    }
}
