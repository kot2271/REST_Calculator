package com.service.adapter.exception;

import com.service.adapter.model.error.Error;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestValueException extends RuntimeException {
    private final List<Error> errors;

    public RequestValueException(List<Error> errors) {
        this.errors = errors;
    }
}
