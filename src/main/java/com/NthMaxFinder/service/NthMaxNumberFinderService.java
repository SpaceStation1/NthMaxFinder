package com.NthMaxFinder.service;

import com.NthMaxFinder.dto.NumberRequest;
import com.NthMaxFinder.util.exception.NumberExceedsTableSizeException;
import com.NthMaxFinder.util.exception.NumberLessThanZeroException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
@RequiredArgsConstructor
public class NthMaxNumberFinderService {

    private final ExelService exelService;

    public Integer findNthMax(NumberRequest request) {
        int n = request.getN();
        if(n <= 0){
            throw new NumberLessThanZeroException();
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);

        Sheet sheet = exelService.fileOpener(request.getFilePath());
        if (n > sheet.getPhysicalNumberOfRows()) {
            throw new NumberExceedsTableSizeException();
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
        return minHeap.peek();
    }
}