package com.NthMaxFinder.util.exception;

import com.NthMaxFinder.util.ErrorType;

public class NumberLessThanZeroException extends BaseInfoServiceException {

    public NumberLessThanZeroException() {
        super("Заданное число должно быть больше 0", ErrorType.VALIDATION_EXCEPTION);
    }
}
