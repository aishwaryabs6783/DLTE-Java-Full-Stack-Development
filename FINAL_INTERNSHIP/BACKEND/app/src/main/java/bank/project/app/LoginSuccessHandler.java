package bank.project.app;


import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    BankService service;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Customer customer = (Customer) authentication.getPrincipal();
        logger.info(customer.toString());
        logger.info("success");
// if(haiUsers.getStatus()!=0){
// if(haiUsers.getAttempts()>0){
// haiUsers.setAttempts(0);
// service.updateAttempt(haiUsers);
// }
        super.setDefaultTargetUrl("/web/UI");
        super.onAuthenticationSuccess(request, response, authentication);
// }
// else {
// logger.error("Maximum attempt reached contact admin to reset");
// super.setDefaultTargetUrl("/web/login");
// super.onAuthenticationSuccess(request, response, authentication);
// }
    }
}