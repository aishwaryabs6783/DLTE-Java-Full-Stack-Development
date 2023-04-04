package Srikanth;

public class Test {
    public static void main(String[] args) {
        Student student = new Student(123,22,"eytdyt","uyryyu");
        Address address1 = new Address(23,"yrufu","yuryyu",56567,"Permanent");
        Address address2 = new Address(34,"iudhiuw","usdq",75865,"Current");
        student.getAddresses().add(address1);
        student.getAddresses().add(address2);
        System.out.println(student);
        DaoOperation daoOperation = new DaoOperation();
        daoOperation.insert(student);
        System.out.println("all works fine");
    }

}
