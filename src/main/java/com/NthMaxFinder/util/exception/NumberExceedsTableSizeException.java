package com.NthMaxFinder.util.exception;

import com.NthMaxFinder.util.ErrorType;

public class NumberExceedsTableSizeException extends BaseInfoServiceException {

    public NumberExceedsTableSizeException() {
        super("Заданное число слишком большое", ErrorType.VALIDATION_EXCEPTION);
    }
}
