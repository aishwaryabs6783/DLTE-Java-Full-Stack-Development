package myservlets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private int card_number;
    private String card_holder;
    private int card_pin;
    private int card_expiry;
    private int limit;

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public int getCard_pin() {
        return card_pin;
    }

    public void setCard_pin(int card_pin) {
        this.card_pin = card_pin;
    }

    public int getCard_expiry() {
        return card_expiry;
    }

    public void setCard_expiry(int card_expiry) {
        this.card_expiry = card_expiry;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setaddress(String address) {
    }
}

