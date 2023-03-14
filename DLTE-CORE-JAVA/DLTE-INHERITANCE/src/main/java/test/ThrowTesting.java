package test;

public class ThrowTesting {
    public static void main(String[] args) {
        Review obj=new Review();
        obj.examining(12);
        System.out.println("hi");

    }
}
class Review {
    void examining(int age) {
    if (age<18){
        throw new ArithmeticException("underage");
    }
    }
}
