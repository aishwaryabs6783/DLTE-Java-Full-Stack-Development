package hibernate.jpa.dlte_spring_001;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.springframework.lang.NonNull;
        import org.springframework.lang.Nullable;

        import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Payment extends PaymentService {
    @Column(nullable = false)
    private String payee_name;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int payee_id;
    @Column(nullable = false)
    private long contact;
    private String ifsc;
    @Column(nullable = false)
    private long acct_num;
    @Column(nullable = false)
    private String upi;
}
