package bank.project.app;


import bank.project.dao.BankService;
import bank.project.dao.Customer;
import bank.project.dao.Payee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.ResourceBundle;


@ComponentScan("bank.project.dao")
@RestController
@RequestMapping("/payee")
public class CustomerController {
    @Autowired
    private BankService bankService;
    Logger logger=LoggerFactory.getLogger(Customer.class);
    ResourceBundle resourceBundle=ResourceBundle.getBundle("property");


    @GetMapping("/username")
    String getUserName(Principal principal){
        return principal.getName();
    }

   // to update payee details
        @PostMapping("/update")
        public String update (@RequestParam("payeeId") Integer payeeId, @RequestParam("payeeName") String
        payeeName, @RequestParam("payeeAccountNumber") Long payeeAccountNumber, @RequestParam("customerId") Integer
        customerId){
            bank.project.dao.Payee payee = new bank.project.dao.Payee();
            payee.setPayeeId(payeeId);
            payee.setPayeeName(payeeName);
            payee.setPayeeAccountNumber(payeeAccountNumber);
            payee.setCustomerId(customerId);
            logger.info("trying to update");
            return bankService.updatePayee(payee);
        }

    }


