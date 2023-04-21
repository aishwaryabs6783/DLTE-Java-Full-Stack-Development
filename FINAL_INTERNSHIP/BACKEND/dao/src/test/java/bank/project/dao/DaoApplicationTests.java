package bank.project.dao;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringOracleJdbcTemplateSlf4jApplicationTests {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    BankService bankService;

    @Test
    //testing to list payee
    public void testlistPayee(){
        Payee p1=new Payee(108,"aafil",1234566789L,101);
        Payee p2=new Payee(120,"archana",98765432190L,103);
        List<Payee> tempList= Stream.of(p1,p2).collect(Collectors.toList());
        String username="aish";
        when(jdbcTemplate.query(eq("Select * from payee join customer on customer.customer_id = payee.customer_id where customer.username=? "),any(RowMapper.class),eq(username))).thenReturn(tempList);
        assertNotEquals(tempList,bankService.listPayee("ash"));
    }

    @Test
    //testing for login through username
    public void testGetUsername() {
        Customer c1 = new Customer(100,"ash","magadi","XYZ Road,ABC Street,122",4567890,"ashley","pass",0);
        String uname = "ashley";
        when(jdbcTemplate.queryForObject(eq("select * from CUSTOMER where USERNAME=?"),any(RowMapper.class),eq(uname))).thenReturn(c1);
        Customer customer1 = bankService.getByUsername("ashley");
        assertSame(c1,customer1);
        assertEquals(c1.getUsername(),customer1.getUsername());
    }
    @Test
    //testing for updating payee
    public void testUpdateProfile(){
        Payee p1=new Payee(108,"aafil",1234566789L,101);
        when(jdbcTemplate.queryForObject(eq("update payee set payee_name=?, payee_account_number=?,customer_id=? where payee_id=?"),any(RowMapper.class),eq(p1.getPayeeId()),eq(p1.getPayeeName()),eq(p1.getPayeeAccountNumber()),eq(p1.getCustomerId()))).thenReturn(p1);
        assertEquals("108has updated",bankService.updatePayee(p1));
    }
    @Test
    //testing to get payee by id
    public void testGetPayeeById(){
        Payee p1=new Payee(108,"aafil",1234566789L,101);
        Integer payeeId=109;
        when(jdbcTemplate.queryForObject(eq("select * from payee where payee_id=?"),any(RowMapper.class),eq(payeeId))).thenReturn(p1);
        assertNotEquals(p1.getPayeeId(),109);
    }
}
