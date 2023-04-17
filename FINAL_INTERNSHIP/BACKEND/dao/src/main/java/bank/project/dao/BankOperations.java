package bank.project.dao;

import java.util.List;
import java.util.Optional;

public interface BankOperations {
    public Customer getByUsername(String username);
    public void incrementFailedAttempts(int id);
    public String updatePayee(Payee payee);
    public String deletePayee(int id);
    public Optional<Payee> getPayeeById(int id);
    public List<Payee> listPayee(String username);


}
