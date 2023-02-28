package aish;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Implementgenerics {
    public static void main(String[] args) {
        operations<String> object=new operations<String>();
        object.setObjects(new String[]{" "," "});
        //System.out.println("enter the data");
        System.out.println(Arrays.toString(object.getObjects()));
        operations<Double> object1=new operations<Double>();
        object1.setObjects(new Double[]{0.0,0.0});
        System.out.println(Arrays.toString(object1.getObjects()));
        //System.out.println("enter the data");

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class operations<T>{
    private  T[] objects;
    public T[] getObjects(){
        return objects;
    }
    public void setObjects(T[] objects){
        this.objects=objects;
    }


}


