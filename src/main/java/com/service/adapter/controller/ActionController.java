package com.service.adapter.controller;

import com.service.adapter.exception.RequestValueException;
import com.service.adapter.mapper.Mapper;
import com.service.adapter.model.ActionRequest;
import com.service.adapter.model.ActionResponse;
import com.service.adapter.service.CalculatorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/calculator")
public class ActionController {
  private final Validator requestValidator;
  private final CalculatorService calculatorService;
  private final Mapper mapper;

  public ActionController(
      @Qualifier("actionRequestValidator") Validator requestValidator,
      CalculatorService calculatorService,
      Mapper mapper) {
    this.requestValidator = requestValidator;
    this.calculatorService = calculatorService;
    this.mapper = mapper;
  }

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    binder.setValidator(requestValidator);
  }

  @PostMapping(path = "/add", produces = "application/json")
  public ActionResponse addNumbers(
      @RequestBody @Valid ActionRequest request, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      throw new RequestValueException(
          mapper.objectErrorsToValidationErrors(bindingResult.getAllErrors()));
    return new ActionResponse(
        calculatorService.add(
            Integer.parseInt(request.getFirstIssue()), Integer.parseInt(request.getSecondIssue())));
  }

  @PostMapping(path = "/divide", produces = "application/json")
  public ActionResponse divideNumbers(
      @RequestBody @Valid ActionRequest request, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      throw new RequestValueException(
          mapper.objectErrorsToValidationErrors(bindingResult.getAllErrors()));
    return new ActionResponse(
        calculatorService.divide(
            Integer.parseInt(request.getFirstIssue()),
            Integer.parseInt((request.getSecondIssue()))));
  }

  @PostMapping(path = "/multiply", produces = "application/json")
  public ActionResponse multiplyNumbers(
      @RequestBody @Valid ActionRequest request, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      throw new RequestValueException(
          mapper.objectErrorsToValidationErrors(bindingResult.getAllErrors()));
    return new ActionResponse(
        calculatorService.multiply(
            Integer.parseInt(request.getFirstIssue()), Integer.parseInt(request.getSecondIssue())));
  }

  @PostMapping(path = "/subtract", produces = "application/json")
  public ActionResponse subtractNumbers(
      @RequestBody @Valid ActionRequest request, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      throw new RequestValueException(
          mapper.objectErrorsToValidationErrors(bindingResult.getAllErrors()));
    return new ActionResponse(
        calculatorService.subtract(
            Integer.parseInt(request.getFirstIssue()), Integer.parseInt(request.getSecondIssue())));
  }
}
