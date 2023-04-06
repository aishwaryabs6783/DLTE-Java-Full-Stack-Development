package dlte.assessment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PLaControl {
    @Autowired
    private PLaRepository pLaRepository;
    @Autowired
    private PLaService pLaService;

    @GetMapping("/status")
    public Optional<PersonalLoanApplication> callFetchByStatus(@PathVariable("status") int cibil, String profession, int income) {
        return pLaService.implementByCibilAndProfessionAndIncome(cibil, profession, income);
    }

    @GetMapping("/rejected")
    public List<String> callToFetchSave(@PathVariable("rejected") String status) {
        return pLaService.implementOnSave(status);
    }
}