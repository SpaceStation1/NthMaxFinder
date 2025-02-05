package com.NthMaxFinder.controller;

import com.NthMaxFinder.dto.NumberRequest;
import com.NthMaxFinder.dto.SuccessResponse;
import com.NthMaxFinder.service.NthMaxNumberFinderService;
import com.NthMaxFinder.service.ResponseBuildHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(value = "Excel Number Service")
public class NthMaxNumberFinderController {

    private final NthMaxNumberFinderService nthMaxNumberFinderService;
    private final ResponseBuildHelper responseBuildHelper;

    @PostMapping("/maxNumber/fetch")
    @ApiOperation(value = "Get the N-th maximum number from an Excel file")
    public ResponseEntity<SuccessResponse> getNthMaxNumber(@RequestBody NumberRequest request) {
        SuccessResponse response = responseBuildHelper.buildResponse(nthMaxNumberFinderService.findNthMax(request));
        return ResponseEntity.ok(response);
    }
}
