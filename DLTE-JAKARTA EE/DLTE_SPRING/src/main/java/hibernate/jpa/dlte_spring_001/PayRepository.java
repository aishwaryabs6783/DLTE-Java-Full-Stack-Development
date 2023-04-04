package hibernate.jpa.dlte_spring_001;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayRepository extends CrudRepository<Payment,Integer> {
    @Query("Select upi from Payment")
    List<String> findAllUpi();

    @Query("select payee_name from Payment where ifsc=:ifsc")
    List<String>findAllByIfsc(String ifsc);

    Optional<Payment> findByIfsc(String ifsc);
}
