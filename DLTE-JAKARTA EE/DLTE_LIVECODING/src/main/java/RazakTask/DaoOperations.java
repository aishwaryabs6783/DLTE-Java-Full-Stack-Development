package RazakTask;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoOperations {
    private Driver driver;
    private String query;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Customer customer;
    public DaoOperations(){
        try {
            driver=new OracleDriver();
            DriverManager.registerDriver(driver);//establishing connection
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AISHWARYA","aishu6783");
            System.out.println("Database Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Customer Insert(Customer customer) throws SQLException {
        query="insert into taskcustomer values(num.nextval,?,?,?,?,?)";//customer query
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,customer.getCust_name());
        preparedStatement.setString(2,customer.getEmail());
        preparedStatement.setString(3,customer.getPan());
        preparedStatement.setInt(4,customer.getContact());
        preparedStatement.setInt(5,customer.getPin());
        int a=preparedStatement.executeUpdate();
        if(a>0){
            return customer;
        }
        else{
            return null;
        }
    }
    public List<Loan> fetch(int id) throws SQLException{

            query="select borrow_name,loan_type,amt,issuedate from loan,mapper1 where mapper1.custo_id=? and loan_num=loan.loannum";//loan query
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();

            List<Loan> data=new ArrayList<Loan>();
            while(resultSet.next()){
                Loan loan=new Loan();
                loan.setBorrowername(resultSet.getString("borrow_name"));
                loan.setLoantype(resultSet.getString("loan_type"));
                loan.setAmt(resultSet.getDouble("amt"));
                loan.setIssuedate(resultSet.getDate("issuedate"));
                data.add(loan);
            }
            return data;



    }

}

