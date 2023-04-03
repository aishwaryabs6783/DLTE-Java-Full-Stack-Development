package dlte.assessment.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PersonalLoanApplication {
    @Id
    @Column(nullable = false)
    private int loanRequestNumber;
    @Column(nullable = false)
    private int amt;
    @Column(nullable = false)
    private int cibil;
    @Column(nullable = false)
    private long aadhar;
    @Column(nullable = false)
    private String pan;
    @Column(nullable = false)
    private String profession;
    @Column(nullable = false)
    private int income;
    @Column(nullable = false)
    private String status;
    @Temporal(TemporalType.DATE)
    private Date requestdate;

}
