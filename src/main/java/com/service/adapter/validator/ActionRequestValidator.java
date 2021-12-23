package com.service.adapter.validator;

import com.service.adapter.model.ActionRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ActionRequestValidator implements Validator {

  public static final String VALUE_NEGATIVE = "value.negative";

  @Override
  public boolean supports(Class<?> aClass) {
    return ActionRequest.class.equals(aClass);
  }

  @Override
  public void validate(Object object, Errors errors) {
    final ActionRequest request = (ActionRequest) object;
    variableValidate("firstIssue", request.getFirstIssue(), errors);
    variableValidate("secondIssue", request.getSecondIssue(), errors);
  }

  private void variableValidate(String variableName, String variableValue, Errors errors) {
    if (variableValue == null) {
      errors.rejectValue(variableName, VALUE_NEGATIVE, "значение отсутствует");
    } else if (variableValue.equals("")) {
      errors.rejectValue(variableName, VALUE_NEGATIVE, "пустое значение");
    } else if (!isInteger(variableValue)) {
      errors.rejectValue(variableName, VALUE_NEGATIVE, "тип значения должен быть int");
    }
  }

  private boolean isInteger(String string) {
    try {
      Integer.parseInt(string);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
