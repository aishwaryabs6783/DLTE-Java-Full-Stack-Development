//package bank.project.dao;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class CustomerController {
//    @Autowired
//    private BankService bankService;
//
//
//    @GetMapping("/retrieve")
//    public List<Customer> callList() {
//       logger.info("Controller about to print all recordd");
//        return bankService.listAll();
//    }
//    @GetMapping("/UP/{username}/{password}")
//    public Optional<Customer> callUP(@PathVariable("username") String username, @PathVariable("password") String password){
//          logger.info("Controller about to list record based on username");
//          logger.log(Level.INFO,resourceBundle.getString("db_get"));
//        return bankService.findByUsername(username,password);
//    }
//}
