package businesslogic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private int card_num,card_pin,limit;
    private String card_holder;
    private Date card_expiry;

    public int getCard_num() {
        return card_num;
    }

    public void setCard_num(int card_num) {
        this.card_num = card_num;
    }

    public int getCard_pin(int card_pin) {
        return this.card_pin;
    }

    public void setCard_pin(int card_pin) {
        this.card_pin = card_pin;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public Date getCard_expiry() {
        return card_expiry;
    }

    public void setCard_expiry(Date card_expiry) {
        this.card_expiry = card_expiry;
    }
}
