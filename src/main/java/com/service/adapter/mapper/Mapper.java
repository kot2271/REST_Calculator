package com.service.adapter.mapper;

import com.service.adapter.model.error.Error;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

  public List<Error> objectErrorsToValidationErrors(List<ObjectError> errors) {
    return errors.stream()
        .map(
            objectError ->
                objectError instanceof FieldError
                    ? new Error(
                        ((FieldError) objectError).getField()
                            + " "
                            + objectError.getDefaultMessage())
                    : new Error(objectError.getDefaultMessage()))
        .collect(Collectors.toList());
  }
}
