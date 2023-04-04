package hibernate.jpa.dlte_spring_001;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends CrudRepository<Payment,Integer> {
}
