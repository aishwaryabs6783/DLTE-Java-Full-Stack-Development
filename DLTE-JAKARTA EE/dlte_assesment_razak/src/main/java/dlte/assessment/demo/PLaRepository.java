package dlte.assessment.demo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PLaRepository extends CrudRepository<PersonalLoanApplication,Integer> {

    @Query(value = "select * from PersonalLoanApplication where cibil>700 and profession=('selfemployed','salaried') and income=(amt*3)",nativeQuery = true)
    //Optional<PersonalLoanApplication> findPersonalLoanApplicationByStatus(int cibil,String profession,int income);
    Optional<PersonalLoanApplication> updateStatus();

    @Query(value="select * from PersonalLoanApplication where status=('rejected')",nativeQuery = true)
    List<String>findAllByStatus(String status);


}