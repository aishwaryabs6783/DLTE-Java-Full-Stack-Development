package finalproject.internship;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> listAll(){
        return jdbcTemplate.query("select * from Customer",new CustomerMapper());
    }

    public Optional<Customer> findByUP(String username, String password) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Customer where username=? and password=?",new Object[]{username,password},new BeanPropertyRowMapper<>(Customer.class)));
    }

    class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customers=new Customer();
            customers.setCustomer_id(rs.getInt("customer_id"));
            customers.setCustomer_name(rs.getString("customer_name"));
            customers.setCustomer_address(rs.getString("customer_address"));
            customers.setCustomer_status(rs.getString("customer_status"));
            customers.setCustomer_contact(rs.getLong("customer_contact"));
            customers.setUsername(rs.getString("username"));
            customers.setPassword(rs.getString("password"));
            return customers;
        }
    }

}
