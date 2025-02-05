package com.NthMaxFinder.util;

import com.NthMaxFinder.dto.ErrorInfoResponse;
import com.NthMaxFinder.util.exception.FileNotFoundException;
import com.NthMaxFinder.util.exception.NumberExceedsTableSizeException;
import com.NthMaxFinder.util.exception.NumberLessThanZeroException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NumberLessThanZeroException.class)
    public ResponseEntity<ErrorInfoResponse> handleNumberLessThanZeroException(
            HttpServletRequest req,
            NumberLessThanZeroException ex) {
        return getErrorInfo(req, ex, ErrorType.VALIDATION_EXCEPTION);
    }

    @ExceptionHandler(NumberExceedsTableSizeException.class)
    public ResponseEntity<ErrorInfoResponse> handleNumberExceedsTableSizeException(
            HttpServletRequest req,
            NumberExceedsTableSizeException ex) {
        return getErrorInfo(req, ex, ErrorType.VALIDATION_EXCEPTION);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorInfoResponse> handleFileNotFoundException(HttpServletRequest req,
                                                                         FileNotFoundException ex) {
        return getErrorInfo(req, ex, ErrorType.PATH_NOT_FOUND);
    }

    private ResponseEntity<ErrorInfoResponse> getErrorInfo(HttpServletRequest req, Exception e, ErrorType errorType) {
        return ResponseEntity.status(errorType.getStatus())
                .body(new ErrorInfoResponse(
                        req.getRequestURI(),
                        errorType.toString(),
                        errorType.getStatus().toString(),
                        e.getMessage()));
    }
}
