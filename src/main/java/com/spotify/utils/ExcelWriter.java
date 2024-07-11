package com.spotify.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class ExcelWriter {
    public static void writeToExcel(String excelFilePath, String excelSheetName, ArrayList<Map<String, String>> dataList) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(excelSheetName);

        int rowIndex = 0;

        for (Map<String, String> data : dataList) {
            Row row = sheet.createRow(rowIndex++);

            int cellIndex = 0;
            for (Map.Entry<String, String> entry : data.entrySet()) {
                Cell cell = row.createCell(cellIndex++);
                cell.setCellValue(entry.getValue());
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
        workbook.close();
    }
}
