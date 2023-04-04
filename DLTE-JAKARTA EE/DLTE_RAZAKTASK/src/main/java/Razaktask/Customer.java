package Razaktask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
   private int cust_id;
   private String cust_name;
   private String email;
   private String pan;
   private int contact;
   private int pin;
}
