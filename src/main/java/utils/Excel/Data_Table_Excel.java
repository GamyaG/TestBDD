package utils.Excel;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data_Table_Excel {

        public  List<Map<String, String>> readExcelData(String filePath, String sheetName) throws IOException {
            List<Map<String, String>> data = new ArrayList<>();

            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(1);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    Cell currentCell = currentRow.getCell(j);
                    CellType cellType = currentCell.getCellType();

                    String columnName = headerRow.getCell(j).getStringCellValue();
                    String cellValue = "";

                    switch (cellType) {
                        case STRING:
                            cellValue = currentCell.getStringCellValue();
                            break;
                        case NUMERIC:
                            cellValue = String.valueOf(currentCell.getNumericCellValue());
                            break;
                        // Handle other cell types as needed

                        default:
                            break;
                    }

                    rowData.put(columnName, cellValue);
                }

                data.add(rowData);
            }

            workbook.close();
            fis.close();

            return data;
        }
    }

