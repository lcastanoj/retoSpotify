package com.spotify.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Excel {
    public static ArrayList<Map<String, String>> readDataFromExcelSheet(String excelFilePath, String excelSheetName) throws IOException {
        ArrayList<Map<String, String>> dataList = new ArrayList<>();
        Map<String, String> projectInformation = new HashMap<>();
        File file = new File(excelFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(excelSheetName);
        Iterator<Row> rowIterator = newSheet.iterator();
        Row titlesRow = rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.getColumnIndex();
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        projectInformation.put(titlesRow.getCell(cell.getColumnIndex()).toString(), cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        projectInformation.put(titlesRow.getCell(cell.getColumnIndex()).toString(), String.valueOf((long) cell.getNumericCellValue()));
                        break;
                    case BLANK:
                        projectInformation.put(titlesRow.getCell(cell.getColumnIndex()).toString(), "");
                        break;
                    default:
                }
            }
            dataList.add(projectInformation);
            projectInformation = new HashMap<>();
        }
        return dataList;
    }

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

    private  static ArrayList<Map<String, String>> data= new ArrayList<>();
    public static ArrayList<Map<String, String>> extractTo(){
        try {
            data= Excel.readDataFromExcelSheet("src/main/resources/data/search.xlsx","Data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}