package com.NthMaxFinder.util.exception;

import com.NthMaxFinder.util.ErrorType;
import lombok.Getter;


@Getter
public class BaseInfoServiceException extends RuntimeException {
    private final ErrorType errorType;

    public BaseInfoServiceException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }
}