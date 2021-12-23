package com.service.adapter.model.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ActionErrorResponse {
    private List<Error> errorsList;
}
