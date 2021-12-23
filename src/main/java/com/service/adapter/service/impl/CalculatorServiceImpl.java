package com.service.adapter.service.impl;

import com.service.adapter.client.CalculatorSOAPClient;
import com.service.adapter.exception.SoapResultException;
import com.service.adapter.model.error.Error;
import com.service.adapter.service.CalculatorService;
import com.service.adapter.wsdl.Add;
import com.service.adapter.wsdl.Divide;
import com.service.adapter.wsdl.Multiply;
import com.service.adapter.wsdl.Subtract;
import com.service.adapter.wsdl.AddResponse;
import com.service.adapter.wsdl.DivideResponse;
import com.service.adapter.wsdl.MultiplyResponse;
import com.service.adapter.wsdl.SubtractResponse;
import lombok.Data;
import org.springframework.stereotype.Service;


@Service
@Data
public class CalculatorServiceImpl implements CalculatorService {

  private static final String ERROR_MESSAGE = "No SOAP calculator response";

  private final CalculatorSOAPClient calculatorSOAPClient;

  @Override
  public int add(int firstIssue, int secondIssue) {
    Add addRequest = new Add();
    addRequest.setIntA(firstIssue);
    addRequest.setIntB(secondIssue);
    AddResponse response = calculatorSOAPClient.add(addRequest);
    if (response == null)
      throw new SoapResultException(new Error(ERROR_MESSAGE));
    return response.getAddResult();
  }

  @Override
  public int divide(int firstIssue, int secondIssue) {
    Divide divideRequest = new Divide();
    divideRequest.setIntA(firstIssue);
    divideRequest.setIntB(secondIssue);
    DivideResponse response = calculatorSOAPClient.divide(divideRequest);
    if (response == null)
      throw new SoapResultException(new Error(ERROR_MESSAGE));
    return response.getDivideResult();
  }

  @Override
  public int multiply(int firstIssue, int secondIssue) {
    Multiply multiplyRequest = new Multiply();
    multiplyRequest.setIntA(firstIssue);
    multiplyRequest.setIntB(secondIssue);
    MultiplyResponse response = calculatorSOAPClient.multiply(multiplyRequest);
    if (response == null)
      throw new SoapResultException(new Error(ERROR_MESSAGE));
    return response.getMultiplyResult();
  }

  @Override
  public int subtract(int firstIssue, int secondIssue) {
    Subtract subtractRequest = new Subtract();
    subtractRequest.setIntA(firstIssue);
    subtractRequest.setIntB(secondIssue);
    SubtractResponse response = calculatorSOAPClient.subtract(subtractRequest);
    if (response == null)
      throw new SoapResultException(new Error(ERROR_MESSAGE));
    return response.getSubtractResult();
  }
}
