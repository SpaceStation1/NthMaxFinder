package com.NthMaxFinder.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;

@Service
public class NthMaxNumberFinderService {

    public Integer findNthMax(String filePath, int n) throws IOException {

        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            if (n > sheet.getPhysicalNumberOfRows()) {
                throw new IllegalArgumentException("N must be less than number count");
            }
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        int number = (int) cell.getNumericCellValue();
                        if (minHeap.size() < n) {
                            minHeap.add(number);
                        } else if (number > minHeap.peek()) {
                            minHeap.poll();
                            minHeap.add(number);
                        }
                    }
                }
            }
        }

        return minHeap.peek();
    }


//
//    public  Integer findNthMax2(int n){
//        int[] nums = {3, 1, 5, 7, 2,8,8,8,8, 8, 4};
//        if (n <= 0 || n > nums.length) {
//            throw new IllegalArgumentException("N must be greater than 0 and less than or equal to the length of the array");
//        }
//        // Используем минимальную кучу для хранения N максимальных чисел
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
//
//        for (int num : nums) {
//            // Добавляем число в кучу
//            if (minHeap.size() < n) {
//                minHeap.add(num);
//            } else if (num > minHeap.peek()) {
//                // Если текущее число больше наименьшего в куче, заменяем его
//                minHeap.poll();
//                minHeap.add(num);
//            }
//        }
//        return minHeap.peek(); // Возвращаем N-ое максимальное число
//    }
}
