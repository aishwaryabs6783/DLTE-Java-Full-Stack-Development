package org.example;



import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    File file = new File("transacc.txt");
    void insertData() throws IOException {
        Scanner scannerObject = new Scanner(System.in);
        Integer reg_num, age;
        String name, email;
        String address;

        System.out.println("enter reg num");
        reg_num = scannerObject.nextInt();
        System.out.println("enter age");
        age = scannerObject.nextInt();
        System.out.println("name");
        name = scannerObject.next();
        System.out.println("email");
        email = scannerObject.next();
        System.out.println("address");
        address = scannerObject.next();

        StudentDetails obj=new StudentDetails(reg_num,age,name,email,address);

        //writing into file
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(obj);
        oos.close();
        fos.close();
    }
    void displayData() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);
        //Reading the data from the file
        System.out.println(ois.readObject());
        ois.close();
        fis.close();

    }
    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        App obj = new App();
        while(true){
            System.out.println("1.Insert\n2.Display\n3.exit\1nEnter your choice:");
            switch (scanner.nextInt()){
                case 1:
                    obj.insertData();
                    break;
                case 2:
                    obj.displayData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice...enter properly");
            }
        }
    }
}
