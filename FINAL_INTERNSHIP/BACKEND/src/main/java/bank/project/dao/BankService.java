package bank.project.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BankService implements BankOperations {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //private Logger logger= (Logger) LoggerFactory.getLogger(BankService.class);
//    ResourceBundle resourceBundle=ResourceBundle.getBundle("Customer");
//    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Object listAll() {
        return jdbcTemplate.query("select * from Customer", new CustomerMapper());
    }

    @Override
    public Optional<Customer> getByUsername(String username, String password) {

        return Optional.of(jdbcTemplate.queryForObject("select * from Customer where username=? and password=?", new Object[]{username, password}, new BeanPropertyRowMapper<>(Customer.class)));

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

}
