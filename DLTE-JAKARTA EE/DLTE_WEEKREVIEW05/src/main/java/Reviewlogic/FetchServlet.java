package Reviewlogic;


        import Week5review.DaoOperate;
        import Week5review.Operation;
        import Week5review.Student;
        import com.google.gson.Gson;
        //        import dlte.daooperate.DaoOperate;
//        import dlte.daooperate.Operation;
//        import dlte.daooperate.Student;
        import lombok.SneakyThrows;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.List;
        import java.util.ResourceBundle;
        import java.util.logging.Level;
        import java.util.logging.Logger;

@WebServlet(name = "FetchServlet", value = "/fetch")
public class FetchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourceBundle bundle=ResourceBundle.getBundle("student");
        Logger logger= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Operation daoOperate=new DaoOperate();
        logger.log(Level.INFO,"Scheme is set!!");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        List<Student> list = daoOperate.fetch();
        PrintWriter printWriter=response.getWriter();
        printWriter.write(gson.toJson(list));
    }

}
