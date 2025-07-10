package helper;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    // ThreadLocal cache for workbooks to ensure thread safety
    private static final ThreadLocal<Workbook> threadLocalWorkbook = new ThreadLocal<>();

    public static Workbook getExcelReader(String xlPath) throws IOException {
        Workbook workbook = threadLocalWorkbook.get();
        if (workbook == null) {
            File file = new File(xlPath);

            if (!file.exists() || !file.canRead()) {
                throw new IOException("File does not exist or cannot be read: " + xlPath);
            }

            try (FileInputStream fis = new FileInputStream(file)) {
                String fileExtension = xlPath.substring(xlPath.lastIndexOf(".")).toLowerCase();

                // Determine the file type and create the appropriate Workbook instance
                if (fileExtension.equals(".xls")) {
                    workbook = new HSSFWorkbook(fis);
                } else if (fileExtension.equals(".xlsx")) {
                    workbook = new XSSFWorkbook(fis);
                } else {
                    throw new IllegalArgumentException("Invalid file format: " + fileExtension);
                }

                // Cache the Workbook in ThreadLocal
                threadLocalWorkbook.set(workbook);
            }
        }
        return workbook;
    }

    public static String getCellDataLabelName(String xlPath, String sheetName, String keyName, String columnName) throws IOException {
        String cellData = null;

        // Get the Workbook instance
        Workbook workbook = getExcelReader(xlPath);
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet not found: " + sheetName);
        }
        List<List<String>> resultTable = fetchResultTable(sheet);

        for (int i = 0; i < resultTable.size(); i++) {
            String keyValue = resultTable.get(i).get(0); // Assuming the key is in the first column
            if (keyValue.equals(keyName)) {
                List<String> headerRow = resultTable.get(0);
                for (int j = 0; j < headerRow.size(); j++) {
                    String colName = headerRow.get(j);
                    if (colName.equals(columnName)) {
                        cellData = resultTable.get(1).get(j);
                        if (cellData == null) {
                            throw new RuntimeException("Value you are trying to enter is empty for " + colName);
                        }
                    }
                }
                break;
            }
        }

        return cellData;
    }

    public static String getCellDataKeyValue(String xlPath, String sheetName, String keyName, String columnName) throws IOException {
        String cellData = null;

        // Get the Workbook instance
        Workbook workbook = getExcelReader(xlPath);
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet not found: " + sheetName);
        }
        List<List<String>> resultTable = fetchResultTable(sheet);

        for (int i = 0; i < resultTable.size(); i++) {
            String keyValue = resultTable.get(i).get(0); // Assuming the key is in the first column
            if (keyValue.equals(keyName)) {
                List<String> headerRow = resultTable.get(0);
                for (int j = 0; j < headerRow.size(); j++) {
                    String colName = headerRow.get(j);
                    if (colName.equals(columnName)) {
                        cellData = resultTable.get(i).get(j);
                        if (cellData == null || cellData.isEmpty()) {
                            throw new RuntimeException("Value you are trying to enter is empty for " + colName);
                        }
                        return cellData;
                    }
                }
                break;
            }
        }

        throw new RuntimeException("Key or column name not found in the sheet");
    }


public static List<List<String>> fetchResultTable(Sheet sheet) {
    List<List<String>> resultTable = new ArrayList<>();
    DataFormatter dataFormatter = new DataFormatter(); // To format cell values as they appear in Excel

    for (Row row : sheet) {
        List<String> rowData = new ArrayList<>();
        for (Cell cell : row) {
            String cellValue = dataFormatter.formatCellValue(cell).trim(); // Get and trim the cell value
            rowData.add(cellValue);
        }
        resultTable.add(rowData);
    }
    return resultTable;
}



}
