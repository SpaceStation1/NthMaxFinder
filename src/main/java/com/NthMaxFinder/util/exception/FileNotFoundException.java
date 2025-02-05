package com.NthMaxFinder.util.exception;

import com.NthMaxFinder.util.ErrorType;


public class FileNotFoundException extends BaseInfoServiceException {

    public FileNotFoundException() {
        super("Ошибка пути или файл отсутствует", ErrorType.PATH_NOT_FOUND);
    }
}