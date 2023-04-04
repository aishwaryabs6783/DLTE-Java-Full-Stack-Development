package hibernate.jpa.dlte_spring_001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Control {
    @Autowired
    private PaymentService payService;
    //hql
    @GetMapping("/upi")
    public List<String> callToFetchUpi(){
        return payService.implementFetchUpi();
    }
    //exact
    @GetMapping("/ifsc/{num}")
    public Optional<Payment> callFetchPan(@PathVariable("num") String ifsc){
        return payService.implementOfIfsc(ifsc);
    }

    @PostMapping("/paymentdetInsert")
    public PaymentService callingSave(@RequestBody Payment payment)
    {
        return payService.implementationOfSave(payment);
    }


    @PutMapping("/change")
    public Payment callUpdate(@RequestBody Payment payment){
        return payService.implementationOfSave(payment);
    }


    @GetMapping("/account/{payee_id}")
    public Optional<Payment> callingFindById(@PathVariable("payee_id") int payee_id){
        return payService.implementOfFindById(payee_id);
    }

    @GetMapping("/retrieve")
    public List<Payment> callingFindAll(){
        return payService.implementOfFindAll();
    }

}