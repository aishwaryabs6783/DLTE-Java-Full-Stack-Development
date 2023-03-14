package concurrency;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class ImpletingExecutors {
    public static void main(String[] args) {
        Wallet wall=new Wallet();
        Thread thread1=new Thread(wall,"Pooja");
       Thread thread2=new Thread(wall,"Surya");
        Thread thread3=new Thread(wall,"Amrutha");
        thread1.start();thread2.start();thread3.start();

        Executor executor= Executors.newCachedThreadPool();
        executor.execute(wall);

        ThreadPoolExecutor pool= (ThreadPoolExecutor) executor;
        pool.shutdown();

    }

}
class Gpay{
    private int id;
    private String type;
    private String mode;
    private int amt;
    private int date;
    
    public Gpay(String x, int i, double v) {
    }

    public void getUsername() {
    }
}
class Wallet implements Runnable {

    Lock lock = new ReentrantLock();

    ArrayList<Gpay> customers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Wallet() {
        customers.add(new Gpay("razzaksr", 1122, 560.9));
        customers.add(new Gpay("sridharm", 9988, 12546.8));
        customers.add(new Gpay("arun", 7892, 8922.5));
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("Welcome admin "+Thread.currentThread().getName());
        System.out.println("Enter the process to proceed by "+Thread.currentThread().getName());
        String process= scanner.next();
        switch (process){
            case "add":
                System.out.println("Enter the username to add ");
                addcustomer(scanner.next());
            case "view":listAll();break;

        }
    }

    private void listAll() {
    }


    private void addcustomer(String username) {
        addcustomer(scanner.next());
        for (int index = 0; index < customers.size(); index++) {

                Gpay current = customers.get(index);
                System.out.println(customers.get(index));
                //System.out.println("Tell us what to update either UPI/ Balance");

        }
    }
}