package bank.project.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MvnController {
    @GetMapping("/log")
    //login ui
    public String login(){
        return "login";
    }
    @GetMapping("/UI")
    //dashboard
    public String Ui(){
        return "dashboard";
    }
    @GetMapping("/updatePayee")
    //update ui
    public String updatePayeeMethod(){
        return "update";
    }
    @GetMapping("/add")
    //add payee ui
    public String addPayee(){
        return "addPayee";
    }
    @GetMapping("/pay")
    //payment transfer ui
    public String paymentTransfer(){
        return "paymentTransfer";
    }
}
