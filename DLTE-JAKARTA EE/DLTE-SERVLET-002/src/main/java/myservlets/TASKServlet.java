package myservlets;

import oracle.jdbc.OracleDriver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TASKServlet")
public class TASKServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            String query="select * from card";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            //connection.close();
            Card card=null;
            List<Card> profiles=new ArrayList<Card>();
            while(resultSet.next()){
                card=new Card();
                card.setCard_number(resultSet.getInt("card_number"));
                card.setCard_holder(resultSet.getString("card_holder"));
                card.setCard_pin(resultSet.getInt("card_pin"));
                card.setCard_expiry(resultSet.getInt("card_expiry"));
                card.setLimit(resultSet.getInt("limit"));
                InputStream inputStream=resultSet.getBinaryStream("address");
                byte[] tempBinary=new byte[inputStream.available()];
                inputStream.read(tempBinary);
                String address=new String(tempBinary);
                card.setaddress(address);
                profiles.add(card);
            }
            RequestDispatcher dispatcher=request.getRequestDispatcher("available.jsp");
            request.setAttribute("dbData",profiles);
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


