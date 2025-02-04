package com.NthMaxFinder.controller;

import com.NthMaxFinder.service.NthMaxNumberFinderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(value = "Excel Number Service")
public class NthMaxNumberFinderController {

    private final NthMaxNumberFinderService nthMaxNumberFinderService;

    @GetMapping("/maxNumber")
    @ApiOperation(value = "Get the N-th maximum number from an Excel file")
    public ResponseEntity<?> getNthMaxNumber(
            @RequestParam("filePath") String filePath,
            @RequestParam(value = "n") int n) {
        try {
            Number number = nthMaxNumberFinderService.findNthMax(filePath, n);
            return new ResponseEntity<>(number, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Ошибка при чтении файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
