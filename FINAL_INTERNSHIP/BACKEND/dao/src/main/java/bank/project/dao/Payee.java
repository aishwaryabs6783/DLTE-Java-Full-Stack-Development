package bank.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payee {
    private int payeeId;
    private String payeeName;
    private Long payeeAccountNumber;
    private int customerId;
}