package helper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelWriter {
    String PolicyNumber;

    private static final Object lock = new Object();

    public static void writeExcel(String filePath, DataTable dataTable) throws IOException {
        synchronized (lock) {
            Workbook workbook;
            Sheet sheet;

            File file = new File(filePath);
            boolean fileExists = file.exists();

            if (fileExists) {
                try (FileInputStream fis = new FileInputStream(filePath)) {
                    workbook = new XSSFWorkbook(fis);
                    sheet = workbook.getSheetAt(0);
                } catch (Exception e) {
                    throw new IOException("Failed to open the existing Excel file. Ensure it is valid.", e);
                }
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Sheet1");
            }

            // Determine the next available row
            int startRow = fileExists ? sheet.getLastRowNum() + 1 : 0;

            // Write data
            List<String[]> data = dataTable.getData();
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(startRow + i);
                String[] rowData = data.get(i);
                for (int j = 0; j < rowData.length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(rowData[j]);
                }
            }

            // Write to a temporary file first
            String tempFilePath = filePath + ".tmp";
            try (FileOutputStream fos = new FileOutputStream(tempFilePath)) {
                workbook.write(fos);
            } finally {
                workbook.close();
            }

            // Replace original file with the new file
            if (fileExists && !file.delete()) {
                throw new IOException("Failed to delete the original file.");
            }

            File tempFile = new File(tempFilePath);
            if (!tempFile.renameTo(file)) {
                throw new IOException("Failed to rename the temporary file.");
            }
        }
    }


    public static void main(String[] args) {
        try {
            DataTable dataTable = new DataTable();

            // Collect data from UI
            // Simulate a row of data
            String policyNumber = "fghjk";
            String firstName = "sdfghjk";
            String lastName = "sdfghjk";
            String state = "Dallas";

            // Add the row as an array of strings
            String[] rowData = {policyNumber, firstName, lastName, state};
            dataTable.addRow(rowData);

            // Write DataTable to Excel
            ExcelWriter.writeExcel("C://JavaBDD//BDDJavaGuidewireFramework//src//main//resources//WorkBooks//PolicyNumbersData.xlsx", dataTable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
