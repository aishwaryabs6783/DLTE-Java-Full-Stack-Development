package RazakTask;

import java.sql.SQLException;
import java.util.Scanner;

public class DaoTest {

     public static void main(String[] args) throws SQLException {
        DaoOperations daoOperations=new DaoOperations();
        Customer customer=new Customer(123,"appoooo","asd","wert67",234567,89);
        daoOperations.Insert(customer);
         Loan loan=new Loan();
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("enter cust id");
//       // System.out.println(daoOperations.fetch(scanner.nextInt()));
//        System.out.println("data fetched");
    }
}
