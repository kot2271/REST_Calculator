package com.service.adapter;

import com.service.adapter.model.ActionRequest;
import com.service.adapter.validator.ActionRequestValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorTest {

  private static final ResourceBundleMessageSource bundleMessageSource =
      new ResourceBundleMessageSource();

  static {
    bundleMessageSource.setBasename("message");
  }

  @Autowired private ActionRequestValidator actionRequestValidator;

  @Test
  public void testEmptyError() {
    final ActionRequest actionRequest = new ActionRequest();
    actionRequest.setFirstIssue("10");
    actionRequest.setSecondIssue("10");
    final DataBinder dataBinder = new DataBinder(actionRequest);
    dataBinder.addValidators(actionRequestValidator);
    dataBinder.validate();
    Assert.assertFalse(dataBinder.getBindingResult().hasErrors());
  }

  @Test
  public void testEmptyValue() {
    final ActionRequest actionRequest = new ActionRequest();
    actionRequest.setFirstIssue("");
    actionRequest.setSecondIssue("5");
    final DataBinder dataBinder = new DataBinder(actionRequest);
    dataBinder.addValidators(actionRequestValidator);
    dataBinder.validate();

    List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();
    Assert.assertEquals(1, errors.size());
    Assert.assertTrue(errors.get(0) instanceof FieldError);
    Assert.assertEquals("firstIssue", ((FieldError) errors.get(0)).getField());
    Assert.assertEquals("пустое значение", errors.get(0).getDefaultMessage());
  }

  @Test
  public void testNullValue() {
    final ActionRequest actionRequest = new ActionRequest();
    actionRequest.setFirstIssue("5");
    actionRequest.setSecondIssue(null);
    final DataBinder dataBinder = new DataBinder(actionRequest);
    dataBinder.addValidators(actionRequestValidator);
    dataBinder.validate();

    List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();
    Assert.assertEquals(1, errors.size());
    Assert.assertEquals("secondIssue", ((FieldError) errors.get(0)).getField());
    Assert.assertEquals("значение отсутствует", errors.get(0).getDefaultMessage());
  }

  @Test
  public void testValueIsNotInt() {
    final ActionRequest actionRequest = new ActionRequest();
    actionRequest.setFirstIssue("десять");
    actionRequest.setSecondIssue("10");
    final DataBinder dataBinder = new DataBinder(actionRequest);
    dataBinder.addValidators(actionRequestValidator);
    dataBinder.validate();

    List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();

    Assert.assertEquals(1, errors.size());
    Assert.assertTrue(errors.get(0) instanceof FieldError);
    Assert.assertEquals("firstIssue", ((FieldError) errors.get(0)).getField());
    Assert.assertEquals("тип значения должен быть int", errors.get(0).getDefaultMessage());
  }

  @Test
  public void testTwoErrors(){
    final ActionRequest actionRequest = new ActionRequest();
    actionRequest.setFirstIssue(null);
    actionRequest.setSecondIssue("");

    final DataBinder dataBinder = new DataBinder(actionRequest);
    dataBinder.addValidators(actionRequestValidator);
    dataBinder.validate();

    List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();

    Assert.assertEquals(2, errors.size());
  }
}
