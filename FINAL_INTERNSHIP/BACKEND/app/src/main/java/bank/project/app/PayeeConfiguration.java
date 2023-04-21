package bank.project.app;

        import org.springframework.boot.web.servlet.ServletRegistrationBean;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.core.io.ClassPathResource;
        import org.springframework.ws.config.annotation.EnableWs;
        import org.springframework.ws.config.annotation.WsConfigurerAdapter;
        import org.springframework.ws.transport.http.MessageDispatcherServlet;
        import org.springframework.ws.transport.http.WebServiceMessageReceiverHandlerAdapter;
        import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
        import org.springframework.xml.xsd.SimpleXsdSchema;
        import org.springframework.xml.xsd.XsdSchema;

        import javax.xml.bind.annotation.XmlSchema;

@EnableWs
@Configuration
//soap configuration for payee
public class PayeeConfiguration extends WsConfigurerAdapter {
    @Bean(name = "payee")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema payeeSchema){
        DefaultWsdl11Definition schemaObject=new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("PayeePort");
        schemaObject.setTargetNamespace("http://soap.bank.service");
        schemaObject.setLocationUri("/PayeePoint");
        schemaObject.setSchema(payeeSchema);
        return schemaObject;
    }
    @Bean
    //payee schema
    public XsdSchema payeeSchema(){
        return new SimpleXsdSchema(new ClassPathResource("Payee.xsd"));
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet,"/PayeePoint/*");
    }
}