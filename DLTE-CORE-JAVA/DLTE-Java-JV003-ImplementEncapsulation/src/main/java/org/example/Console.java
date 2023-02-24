package org.example;

import java.util.Scanner;
    //implemented the gpay class
    public class Console {
        public static void main(String[] args) {
            Fund fund=new Fund(4326652L, 213543, 5000, "aishwarya" );
            System.out.println(fund.toString());
            System.out.println(fund.getName()+" "+fund.getAccountNumber()+" "+fund.getBalance()+" "+fund.getUpipin());
            fund.fundTransfer();
            fund.recharge();
            fund.recharge("123467ghnn");
        }
    }
    //this Fund class includes getter and setter ,tostring method
    class Fund{

        Scanner scanner = new Scanner(System.in);

        private long accountNumber;
        private Integer upipin;
        private double balance;
        private String name;

        public Fund(long accountNumber, Integer upipin, double balance, String name) {
            this.accountNumber = accountNumber;
            this.upipin = upipin;
            this.balance = balance;
            this.name = name;
        }
        @Override
        public String toString() {
            return "Fund{" +
                    "accountNumber=" + accountNumber +
                    ", upipin=" + upipin +
                    ", balance=" + balance +
                    ", name='" + name + '\'' +
                    '}';
        }

        public long getAccountNumber(){
            return this.accountNumber;
        }

        public void setAccountNumber ( long accountNumber){
            this.accountNumber = accountNumber;
        }

        public Integer getUpipin () {
            return upipin;
        }

        public void setUpipin (Integer upipin){
            this.upipin = upipin;
        }

        public double getBalance () {
            return balance;
        }

        public void setBalance ( double balance){
            this.balance = balance;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }
        //method to transfer the fund
        public void fundTransfer(){
            System.out.println("Enter the Fund to be transfered:");

            float amount = scanner.nextFloat();
            if(amount<=balance) {
                balance -= amount;

                System.out.println("Enter UPI ID");
                Integer upi = scanner.nextInt();
                if (upi.equals(this.upipin))
                    System.out.println(amount + " has been Successfully Transfered, Available balance Rs " + balance);
                else
                    System.out.println("Wrong pin entered");
            }
            else  System.out.println("fund transfer unsucessful!!");
        }
        //method to recharge using method overriding concept
        public void recharge(){
            System.out.println("Enter the amount to be recharged:");
            int amount=scanner.nextInt();
            if(amount<=balance) {
                balance -= amount;
                System.out.println("Enter UPI ID");
                Integer upi = scanner.nextInt();
                if (upi.equals(this.upipin))
                    System.out.println("Recharge of " + amount + " is Successfull, Available balance Rs " + balance);
                else
                    System.out.println("Wrong pin entered");
            }
            else
                System.out.println("Recharge of "+amount+" is unsuccessful!!");

        }
        //method to recharge  a FASTAG for vechile using concept of method overriding
        public void recharge(String vechile ){
            System.out.println("Enter the FASTAG amount to be recharged:");
            int amount=scanner.nextInt();
            if(amount<=balance) {
                balance -= amount;
                System.out.println("Enter UPI ID");
                Integer upi = scanner.nextInt();
                if (upi.equals(this.upipin))
                    System.out.println("Recharge of " + amount + " is Successfull for vechile No: " + vechile+" Available balance Rs " + balance);
                else
                    System.out.println("Wrong pin entered");
            }
            else
                System.out.println("Recharge of  FASTAG "+amount+" is unsuccessful!!");


        }

    }


