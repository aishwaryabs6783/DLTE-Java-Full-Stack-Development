package dlte.assessment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PLaControl {
    @Autowired
    private PLaRepository pLaRepository;
    @Autowired
    private PLaService pLaService;
    @PutMapping("/update")
    public void  callUpdateStatus(){
        PLaService.implementByCibilAndProfessionAndIncome();
    }

}