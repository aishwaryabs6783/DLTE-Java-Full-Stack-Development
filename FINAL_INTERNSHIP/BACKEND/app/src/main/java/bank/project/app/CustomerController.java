package bank.project.app;


import bank.project.dao.BankService;
import bank.project.dao.Customer;
import bank.project.dao.Payee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;


@ComponentScan("bank.project.dao")
@RestController
@RequestMapping("/aish")
public class CustomerController {
    @Autowired
    private BankService bankService;
    Logger logger=LoggerFactory.getLogger(Customer.class);
    ResourceBundle resourceBundle=ResourceBundle.getBundle("property");

//    @PutMapping("/updatePayee")
//    public String callUpdate(@RequestBody Payee payee) {
//        System.out.println(payee);
//       // logger.info(payee.getPayee_id() + " has trying to update the profile");
//        return bankService.updatePayee(payee);
//
//    }

    @DeleteMapping("/{id}")
    public String callDelete(@PathVariable("id") int id) {
        logger.error("Controller about to delete record based on " + id);
        return bankService.deletePayee(id);
    }
    @GetMapping("/")
    public List<Customer> callList(){
        return bankService.listCustomer();
    }


    @PostMapping("/authenticate")
    public String callLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
        logger.info("Entered sample function");
        Customer customer = bankService.getByUsername(username);
        System.out.println(customer);
        if (customer == null)
            return resourceBundle.getString("db_user");
        else {
            logger.info(customer.getCustomer_status());
            if (customer.getCustomer_status().equalsIgnoreCase("Inactive"))
                return resourceBundle.getString("db_unsuccessfull");
            if (!password.equals(customer.getPassword())) {
                bankService.incrementFailedAttempts(customer.getCustomer_id());
                return resourceBundle.getString("db_incorrect_pw");
            } else
                return resourceBundle.getString("db_success");
        }
    }

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


