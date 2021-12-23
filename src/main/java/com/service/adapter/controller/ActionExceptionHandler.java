package com.service.adapter.controller;

import com.service.adapter.exception.RequestValueException;
import com.service.adapter.exception.SoapResultException;
import com.service.adapter.model.error.ActionErrorResponse;
import com.service.adapter.model.error.Error;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class ActionExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(RequestValueException.class)
  public final ActionErrorResponse handleActionRequestValueException(RequestValueException e) {
    return new ActionErrorResponse(e.getErrors());
  }

  @ExceptionHandler(SoapResultException.class)
  public final ActionErrorResponse handleSoapResponseValueException(SoapResultException e) {
    List<Error> errors = new ArrayList<>();
    errors.add(e.getError());
    return new ActionErrorResponse(errors);
  }
}
