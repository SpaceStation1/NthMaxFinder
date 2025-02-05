package com.NthMaxFinder.service;

import com.NthMaxFinder.dto.SuccessResponse;
import org.springframework.stereotype.Service;

@Service
public class ResponseBuildHelper {

    public SuccessResponse buildResponse(Integer i){
        SuccessResponse numberResponse = new SuccessResponse();
        numberResponse.setCode("200");
        numberResponse.setMessage("FETCH_NUMBER");
        numberResponse.setDescription("Максимальное число из файла взято успешно");
        numberResponse.setMaxNumber(i);
        return numberResponse;
    }
}