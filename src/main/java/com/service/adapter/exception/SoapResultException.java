package com.service.adapter.exception;

import com.service.adapter.model.error.Error;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Data
@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SoapResultException extends RuntimeException {
    private final Error error;

    public SoapResultException(Error error) {
        this.error = error;
    }
}
