package Reviewlogic;



import Week5review.DaoOperate;
import Week5review.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteServlet",value = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        ResourceBundle bundle = ResourceBundle.getBundle("student");
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.log(Level.INFO,"enterde the servlet");
        int reg_no = Integer.parseInt(request.getParameter("regno"));
        Operation daOoperations = new DaoOperate();
        daOoperations.deleteDb(reg_no);
        logger.log(Level.INFO, String.valueOf(reg_no));
        logger.log(Level.INFO, bundle.getString("dbDelete"));

        daOoperations.deleteDb(reg_no);
    }
}