package com.service.adapter.configuration;

import com.service.adapter.client.CalculatorSOAPClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SOAPConfiguration {
  private static final String COM_SERVICE_ADAPTER_WSDL = "com.service.adapter.wsdl";

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath(COM_SERVICE_ADAPTER_WSDL);
    return marshaller;
  }

  @Bean
  public CalculatorSOAPClient calculatorSOAPClient(Jaxb2Marshaller marshaller) {
    CalculatorSOAPClient soapClient = new CalculatorSOAPClient();
    soapClient.setMarshaller(marshaller);
    soapClient.setUnmarshaller(marshaller);
    return soapClient;
  }
}
