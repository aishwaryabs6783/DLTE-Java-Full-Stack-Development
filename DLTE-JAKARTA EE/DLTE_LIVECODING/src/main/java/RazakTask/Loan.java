package RazakTask;

import lombok.Data;

import java.util.Date;
@Data
public class Loan {
    private int loannum;
    private String borrowername;
    private String loantype;
    private double amt;
    private Date issuedate;

}
