package dlte.assessment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PLaService {
    @Autowired
    PLaRepository repository;

    public static void implementByCibilAndProfessionAndIncome() {
    }

    public Optional<PersonalLoanApplication> implementByCibilAndProfessionAndIncome(int cibil, String profession, int income) {
        return repository.findPersonalApplicationByStatus(cibil,profession,income);
    }

    public List<String> implementOnSave(String status){
        return repository.findAllByStatus(status);
    }

}
