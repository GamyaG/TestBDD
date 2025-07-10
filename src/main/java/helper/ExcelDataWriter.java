package helper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDataWriter {

    // Method to write data to Excel based on column header
    public static void writeDataToExcel(String excelFilePath, String columnName, String dataToWrite) {
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Find the column index based on the column header
            int columnIdx = -1;
            Row headerRow = sheet.getRow(0); // Assuming the first row is the header

            // Iterate over the header cells to find the column index
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                    columnIdx = cell.getColumnIndex();
                    break;
                }
            }

            if (columnIdx == -1) {
                throw new RuntimeException("Column '" + columnName + "' not found.");
            }

            // Find the first row where at least one column has data
            int firstAvailableRow = findFirstAvailableRow(sheet);

            // Write data to the first available row in the specified column
            Row dataRow = sheet.getRow(firstAvailableRow);
            if (dataRow == null) {
                dataRow = sheet.createRow(firstAvailableRow);
            }

            Cell dataCell = dataRow.createCell(columnIdx);
            dataCell.setCellValue(dataToWrite);

            // Save changes to the file
            try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                workbook.write(fos);
                System.out.println("Data written successfully to column: " + columnName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to find the first row where at least one column has data
    private static int findFirstAvailableRow(Sheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) { // Start from row 1 (after the header)
            Row row = sheet.getRow(i);
            if (row == null || isRowEmpty(row)) {
                return i;
            }
        }
        return lastRowNum + 1;
    }

    // Helper method to check if a row is empty (i.e., all cells are blank)
    private static boolean isRowEmpty(Row row) {
        for (Cell cell : row) {
            if (cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Specify the file path, column name, and data to write
        String excelFilePath = "C:\\JavaBDD\\BDDJavaGuidewireFramework\\src\\main\\resources\\WorkBooks\\PolicyNumbersData.xlsx";
        String columnName1 = "PolicyNumber";
        String dataToWrite1 = "12345678";

        String columnName2 = "FirstName";
        String dataToWrite2 = "sdfghj";

        // Write data to Excel for both columns
        writeDataToExcel(excelFilePath, columnName1, dataToWrite1);
        writeDataToExcel(excelFilePath, columnName2, dataToWrite2);
    }
}
