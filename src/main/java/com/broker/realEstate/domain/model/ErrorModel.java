package com.broker.realEstate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorModel {

    public final int code;
    public final String message;

}
