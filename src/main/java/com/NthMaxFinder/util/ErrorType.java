package com.NthMaxFinder.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorType {

    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST),
    PATH_NOT_FOUND(HttpStatus.NOT_FOUND);

    private final HttpStatus status;
}
