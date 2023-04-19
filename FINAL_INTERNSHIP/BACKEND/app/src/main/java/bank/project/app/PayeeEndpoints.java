package bank.project.app;

import bank.project.dao.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import service.bank.soap.ListPayeeRequest;
import service.bank.soap.ListPayeeResponse;
import service.bank.soap.Payee;
import service.bank.soap.ServiceStatus;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

@Endpoint
public class PayeeEndpoints {
    private static final String url="http://soap.bank.service";
    private Logger logger= LoggerFactory.getLogger(PayeeEndpoints.class);

    @Autowired
    private BankService bankService;


    @PayloadRoot(namespace = url,localPart = "listPayeeRequest")
    @ResponsePayload
    public ListPayeeResponse listPayeeResponse(@RequestPayload ListPayeeRequest listPayeeRequest){
        ListPayeeResponse response=new ListPayeeResponse();
        ServiceStatus serviceStatus=new ServiceStatus();

        List<bank.project.dao.Payee> jpaComponent = bankService.listPayee(listPayeeRequest.getUsername());// pojo objects
        List<service.bank.soap.Payee> payeeList=new ArrayList<>();// xml list of objects as of its empty

        Iterator<bank.project.dao.Payee> it= jpaComponent.iterator();
        while(it.hasNext()){
            Payee payee = new Payee();// XSD POJO
            BeanUtils.copyProperties(it.next(),payee);
            payeeList.add(payee);

        }
//        response.setServiceStatus(serviceStatus);
        response.getPayee().addAll(payeeList);
        logger.info(response.toString());
        return response;

    }


}