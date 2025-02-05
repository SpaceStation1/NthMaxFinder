package com.NthMaxFinder.service;

import com.NthMaxFinder.util.exception.FileNotFoundException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ExelService {

    public Sheet fileOpener(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            return workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }
}