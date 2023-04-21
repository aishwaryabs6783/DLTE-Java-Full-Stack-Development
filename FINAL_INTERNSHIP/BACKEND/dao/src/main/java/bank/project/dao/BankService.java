package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


@Service
public class BankService implements BankOperations , UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    Logger logger= LoggerFactory.getLogger(BankService.class);
    ResourceBundle resourceBundle=ResourceBundle.getBundle("property");

    @Override
    //service to login using username
    public Customer getByUsername(String username) {
        try {
            Customer customer = jdbcTemplate.queryForObject("select * from CUSTOMER where USERNAME=?", new BankService.CustomerMapper(), username);
            logger.info("GetByUsername "+" "+username+ customer);
            return customer;
        } catch (DataAccessException e) {
            return null;
        }
    }
    //service to get attempts
    public int getAttempts(int id) {
        int attempts = jdbcTemplate.queryForObject("select FAILED_ATTEMPTS from CUSTOMER where CUSTOMER_ID=?",Integer.class,id);
        logger.info("Returned Attempts");
        return attempts;
    }
    //service to set attempts
    public void setAttempts(int id){
        jdbcTemplate.update("update customer set failed_attempts=3 where customer_id=?",id);
        logger.info("set attempts to 3");
    }

    @Override
    //service for incrementing attempts
    public void incrementFailedAttempts(int id) {
        jdbcTemplate.update("update CUSTOMER set FAILED_ATTEMPTS = FAILED_ATTEMPTS + 1 where CUSTOMER_ID=?", id);
        jdbcTemplate.update("update CUSTOMER set CUSTOMER_STATUS='Inactive' where FAILED_ATTEMPTS=3");
    }
    //service to update payee
    @Override
    public String updatePayee(Payee payee) {
        //String information = payee.getPayeeId()+ " has updated";
        logger.info("updated");
        jdbcTemplate.update("update payee set payee_name=?, payee_account_number=?,customer_id=? where payee_id=?",
                new Object[]{payee.getPayeeName(), payee.getPayeeAccountNumber(),payee.getCustomerId(),payee.getPayeeId()});
        return payee.getPayeeId()+resourceBundle.getString("db_update");
    }

//        @Override
//        public String deletePayee(int id){
//            String information=getPayeeById(id).get().getPayeeName()+" has deleted";
//            logger.info("deleted");
//            jdbcTemplate.update("delete from payee where payee_id=?",new Object[]{id});
//            return information;
//        }
        @Override
        public Optional<Payee> getPayeeById(int id){
            return Optional.of(jdbcTemplate.queryForObject("select * from payee where payee_id=?",new Object[]{id},
                    new BeanPropertyRowMapper<>(Payee.class)));
        }
        //service to list customers
        public List<Customer>listCustomer(){
            return jdbcTemplate.query("select * from customer",new CustomerMapper());
        }

        //service to list payee
        public List<Payee> listPayee(String username){
            logger.info(" Get by username ");
            return jdbcTemplate.query("Select * from payee join customer on customer.customer_id = payee.customer_id where customer.username=? ",new PayeeMapper(),username);

        }
        //service to get status of payee
    public void updateStatus() {
        jdbcTemplate.update("update customer set customer_status='Inactive' where attempts=3");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer=getByUsername(username);
        logger.info("LoadByUsername " + username + " "+ customer);
        if(customer==null)
            throw new UsernameNotFoundException("Invalid username");
        logger.info(customer.toString());
        return customer;
    }

    class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

            Customer customers = new Customer();
            customers.setCustomer_id(rs.getInt("customer_id"));
            customers.setCustomer_name(rs.getString("customer_name"));
            customers.setCustomer_address(rs.getString("customer_address"));
            customers.setCustomer_status(rs.getString("customer_status"));
            customers.setCustomer_contact(rs.getLong("customer_contact"));
            customers.setUsername(rs.getString("username"));
            customers.setPassword(rs.getString("password"));
            customers.setFailed_attempts(rs.getInt("failed_attempts"));
            return customers;
        }
    }
        class PayeeMapper implements RowMapper<Payee> {
            @Override
            public Payee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Payee payee = new Payee();
                payee.setPayeeId(rs.getInt("payee_id"));
                payee.setPayeeName(rs.getString("payee_name"));
                payee.setPayeeAccountNumber(rs.getLong("payee_account_number"));
                payee.setCustomerId(rs.getInt("customer_id"));
                return payee;
            }

        }
    }

