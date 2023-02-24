package org.example;
import java.util.Scanner;
public class PersonnelCalculator {
    public static void main(String[] args) {
        Scanner scannerObject=new Scanner(System.in);
        Integer amt,tenure;
        Double emi,interest;
        Double rate;
        System.out.println("enter amt");
        amt= scannerObject.nextInt();

        System.out.println("enter rate");
        rate=scannerObject.nextDouble();
        rate=rate/(12*100);

        System.out.println("enter tenure");
        tenure= scannerObject.nextInt();
        tenure=tenure*12;


        emi= (amt*rate*Math.pow(1+rate,tenure))/(Math.pow(1+rate,tenure)-1);
        System.out.println(emi);
        System.out.println("total interest paid is"+(interest=emi*tenure));
        System.out.println("total REPAYMENT paid is"+(amt+interest));


    }

}
