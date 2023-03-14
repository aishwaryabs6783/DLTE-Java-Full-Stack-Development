/*package example;
//private method
public class Access {
    public static void main(String[] args) {
        System.out.println("hello");
        abc obj =new abc();
        obj.show();

    }
}
class abc{
    int age;

    private void show(){
        System.out.println("good morning");
    }
}*/

//public method
package example;
public class Access {
    public static void main(String[] args) {
        System.out.println("hello");
        abc obj =new abc();
        obj.show();

    }
}
class abc{
    int age;
    public void show(){
        System.out.println("good morning");
    }
}
//default method
/*package example;
public class Access {
    public static void main(String[] args) {
        System.out.println("hello");
        abc obj =new abc();
        obj.show(); //show is in other package u cannot access it since it is default

    }
}
class abc{

}*/
//protected
/*package example;
public class Access {
    public static void main(String[] args) {
        System.out.println("hello");
        abc obj =new abc();
        obj.show();
    }
}
class abc extends Access {
    protected void show(){
        System.out.println("good morning");
    }
}
*/
