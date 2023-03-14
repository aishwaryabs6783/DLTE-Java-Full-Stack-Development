package example;

public class hello {
        public static void main(String[] args) {
            System.out.println("hello world");
            Review obj=new Review();
            obj.examining();
        }
}
class Review{
    void examining(){
        int a=10,b=0,d;
        String var=null;
        int c[]=new int[5];
        try{
            //d=a/b;
            //System.out.println(c[10]);
            System.out.println(var.length());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }catch (ArithmeticException x){
            System.out.println(x);
        }catch(NullPointerException y){
            System.out.println(y);
        }
        System.out.println("testing done");
    }
}