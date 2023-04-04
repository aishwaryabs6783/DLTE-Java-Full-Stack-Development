package hibernate.jpa.dlte_spring_001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private  PayRepository repository;
    //HQL
    public  List<String> implementFetchUpi(){

        return repository.findAllUpi();
    }
    //exact
    public  Optional<Payment> implementOfIfsc(String ifsc){
        return repository.findByIfsc(ifsc);
    }

    public Optional<Payment> implementOfFindById(int payee_id)
    {
        return repository.findById(payee_id);
    }

    public List<Payment> implementOfFindAll()
    {
        return (List<Payment>) repository.findAll();
    }
    public Payment implementationOfSave(Payment payment){

        return repository.save(payment);
    }

}