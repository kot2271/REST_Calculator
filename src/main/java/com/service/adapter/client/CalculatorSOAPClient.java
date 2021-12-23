package com.service.adapter.client;

import com.service.adapter.wsdl.Add;
import com.service.adapter.wsdl.Divide;
import com.service.adapter.wsdl.Multiply;
import com.service.adapter.wsdl.Subtract;
import com.service.adapter.wsdl.AddResponse;
import com.service.adapter.wsdl.DivideResponse;
import com.service.adapter.wsdl.MultiplyResponse;
import com.service.adapter.wsdl.SubtractResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalculatorSOAPClient extends WebServiceGatewaySupport {

  private static final String URI = "http://www.dneonline.com/calculator.asmx";
  private static final String TEMP_URI_ORG_ADD = "http://tempuri.org/Add";
  private static final String TEMP_URI_ORG_DIVIDE = "http://tempuri.org/Divide";
  private static final String TEMP_URI_ORG_MULTIPLY = "http://tempuri.org/Multiply";
  private static final String TEMP_URI_ORG_SUBTRACT = "http://tempuri.org/Subtract";

  public AddResponse add(Add addRequest) {
    return (AddResponse)
        getWebServiceTemplate()
            .marshalSendAndReceive(URI, addRequest, new SoapActionCallback(TEMP_URI_ORG_ADD));
  }

  public DivideResponse divide(Divide divideRequest) {
    return (DivideResponse)
        getWebServiceTemplate()
            .marshalSendAndReceive(URI, divideRequest, new SoapActionCallback(TEMP_URI_ORG_DIVIDE));
  }

  public MultiplyResponse multiply(Multiply multiplyRequest) {
    return (MultiplyResponse)
        getWebServiceTemplate()
            .marshalSendAndReceive(
                URI, multiplyRequest, new SoapActionCallback(TEMP_URI_ORG_MULTIPLY));
  }

  public SubtractResponse subtract(Subtract subtractRequest) {
    return (SubtractResponse)
        getWebServiceTemplate()
            .marshalSendAndReceive(
                URI, subtractRequest, new SoapActionCallback(TEMP_URI_ORG_SUBTRACT));
  }
}
