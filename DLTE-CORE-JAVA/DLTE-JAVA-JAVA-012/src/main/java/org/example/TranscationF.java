package org.example;

import lombok.Data;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TranscationF  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Creating a new file
        File file = new File("transacc.txt");
        Transaction t1 = new Transaction(12,"2023-01-08","CREDIT",1000.0,"UPI");
        Transaction t2 = new Transaction(200,"2023-02-05","DEBIT",2000.0,"NEFT");
        Transaction t3 = new Transaction(420,"2023-03-09","CREDIT",3000.0,"UPI");
        Transaction t4 = new Transaction(789,"2023-02-12","DEBIT",4000.0,"RTGS");
        Transaction t5 = new Transaction(100,"2023-01-20","Debit",5000.0,"UPI");

        FileOutputStream fos=new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        //Adding objects to the list
        List<Transaction> list = Stream.of(t1,t2,t3,t4,t5).collect(Collectors.toList());
        System.out.println("Before Sorting:");
        list.forEach(v-> System.out.println(v));
        //Writing list to the file
        oos.writeObject(list);
        oos.close();
        fos.close();

        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);
        //Reading the data from the file
        List<Transaction> readList=(List<Transaction>) ois.readObject();
        ois.close();
        fis.close();

        //Sorting the list by date
        Collections.sort(readList, new SortByDate());
        System.out.println("\nAfter Sorting (By Date):");
        readList.forEach(v -> System.out.println(v));
    }
}

@Data
class Transaction implements Serializable{
    private Integer id;
    private String date;
    private  String type;
    private Double amount;
    private String mode;

    public Transaction(Integer id, String date, String type, Double amount, String mode) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.mode = mode;
    }

    public String getDate() {
        return date;
    }
}

class SortByDate implements Comparator<Transaction>{

    public int compare(Transaction o1, Transaction o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
