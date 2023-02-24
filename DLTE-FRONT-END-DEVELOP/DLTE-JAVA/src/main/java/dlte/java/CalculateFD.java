package dlte.java;


import java.util.Scanner;

public class CalculateFD {
    public static void main(String[] args) {
        Scanner scannerObject= new Scanner(System.in);



        // non literal way
        Integer amount,duration=3;
        Double maturity=0.0,interest=6.4;
        System.out.println("enter amt");
        amount= scannerObject.nextInt();

        System.out.println("enter duration");
        duration= scannerObject.nextInt();

        //maturity=(amount+(amount*duration)*interest)/100;
        if(duration>1){
            maturity=amount+(amount*interest)/100;
            while(duration>1){
                maturity+=(maturity*interest)/100;
                duration--;
            }
            System.out.println( maturity+"is the money u get after"+duration+"years of"+amount);
        }

    }
}
