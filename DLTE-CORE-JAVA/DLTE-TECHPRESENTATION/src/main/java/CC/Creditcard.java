package CC;

import java.util.ArrayList;
import java.util.Iterator;

public class Creditcard {
    private String card_number;
    private String date;
    private double bill;
    private String card_holder;

    public Creditcard(String card_number, String date, double bill, String card_holder) {
        this.card_number = card_number;
        this.date = date;
        this.bill = bill;
        this.card_holder = card_holder;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getDate() {
        return date;
    }

    public double getBill() {
        return bill;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public static void main(String[] args) {
        // Create an array list of credit cards
        ArrayList<Creditcard> creditCards = new ArrayList<Creditcard>();
        creditCards.add(new Creditcard("23456789", "2023-02-06", 700.0, "DONALD TRUMP"));
        creditCards.add(new Creditcard("98765432", "2023-03-07", 0.0, "JOE BIDEN"));
        creditCards.add(new Creditcard("56789043", "2023-01-08", 25000.0, "MODI"));

        // Search for credit cards with a specific date
        String searchDate = "2023-03-07";
        Iterator<Creditcard> iterator = creditCards.iterator();
        while (iterator.hasNext()) {
            Creditcard creditCard = iterator.next();
            if (creditCard.getDate().equals(searchDate)) {
                // deletes credit card of bill 0
                if (creditCard.getBill() == 0.0) {
                    iterator.remove();
                }
            }
        }

        // Print the updated list of credit cards
        for (Creditcard Creditcard : creditCards) {
            System.out.println("Card Number: " + Creditcard.getCard_number() + ", Date: " + Creditcard.getDate() +
                    ", Bill: " + Creditcard.getBill() + ", Card Holder: " + Creditcard.getCard_holder());
        }
    }
}


