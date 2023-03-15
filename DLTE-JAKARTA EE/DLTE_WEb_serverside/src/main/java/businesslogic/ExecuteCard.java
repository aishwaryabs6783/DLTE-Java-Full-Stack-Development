package businesslogic;

import javax.xml.ws.Endpoint;

public class ExecuteCard {
    private static String url="http://localhost:8082/crudl";
    public static void main(String[] args) {
        CardCRUDL cardCRUDL=new CardCRUDL();
        System.out.println("Webservice is running on "+url);
        Endpoint.publish(url,cardCRUDL);
    }
}
