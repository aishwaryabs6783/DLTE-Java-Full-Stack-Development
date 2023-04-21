package bank.project.app;


import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    BankService bankService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResourceBundle bundle=ResourceBundle.getBundle("property");
        String userName=request.getParameter("username");
        String passWord=request.getParameter("password");
        Customer customer=bankService.getByUsername(userName);
        if(customer==null){
            exception=new LockedException(bundle.getString("db_user"));
            super.setDefaultFailureUrl("/web/log/?error="+ bundle.getString("db_user"));
        }
        else{
            if(customer.getCustomer_status().equalsIgnoreCase("inactive")){
                logger.info(bundle.getString("db_unsuccessfull"));
                exception=new LockedException(bundle.getString("db_unsuccessfull"));
                super.setDefaultFailureUrl("/web/log/?error="+ bundle.getString("db_unsuccessfull"));
            }
            else{
                bankService.incrementFailedAttempts(customer.getCustomer_id());
                int attempts=bankService.getAttempts(customer.getCustomer_id());
                if(attempts==1){
                    logger.info(bundle.getString("db_incorrect_pw")+bundle.getString("attempt2"));
                    exception=new LockedException(bundle.getString("attempt2")+bundle.getString("db_incorrect_pw"));
                    super.setDefaultFailureUrl("/web/log/?error="+ bundle.getString("db_incorrect_pw")+bundle.getString("attempt2"));
                }
                else if(attempts==2){
                    logger.info(bundle.getString("db_incorrect_pw")+bundle.getString("attempt1"));
                    exception=new LockedException(bundle.getString("attempt1")+bundle.getString("db_incorrect_pw"));
                    super.setDefaultFailureUrl("/web/log/?error="+ bundle.getString("db_incorrect_pw")+bundle.getString("attempt1"));
                }
                else{
                    logger.info(bundle.getString("db_unsuccessfull"));
                    exception=new LockedException(bundle.getString("db_unsuccessfull"));
                    bankService.updateStatus();
                    super.setDefaultFailureUrl("/web/log/?error=" + bundle.getString("db_unsuccessfull"));
                }
            }}
        super.onAuthenticationFailure(request, response, exception);
    }
}