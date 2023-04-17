package bank.project.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MvnController {
    @GetMapping("/log")
    public String login(){
        return "login";
    }
    @GetMapping("/UI")
    public String Ui(){
        return "UI";
    }
    @GetMapping("/updatePayee")
    public String updatePayeeMethod(){
        return "update";
    }
}
