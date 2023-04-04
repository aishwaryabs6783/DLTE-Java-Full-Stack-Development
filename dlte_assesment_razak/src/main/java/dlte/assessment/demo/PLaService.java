package dlte.assessment.demo;

import ch.qos.logback.core.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PLaService {
    @Autowired
    PLaRepository repository;

    public static void implementByCibilAndProfessionAndIncome() {
    }

    public Optional<PersonalLoanApplication> implementByCibilAndProfessionAndIncome(int cibil, String profession, int income) {
        return repository.updateStatus();
    }

    public void implementByStatus(Status status) {
        // return repository.findAllByStatus(status);
    }

}
