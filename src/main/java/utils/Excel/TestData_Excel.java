package utils.Excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class TestData_Excel {
    public XSSFRow Row;
    public XSSFCell Cell;

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public TestData_Excel() throws IOException {
        FileInputStream fis=new FileInputStream("src\\main\\resources\\WorkBook\\User_Registration_Data.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("UserRegistration");

    }


    public String getCellData ( int rownum, int columnum) throws IOException {

        Row = sheet.getRow(rownum);
        Cell = Row.getCell(columnum);
        DataFormatter formatter = new DataFormatter();
        String data;
        try {
            data = formatter.formatCellValue(Cell);

        } catch (Exception e) {
            data = "";


        }

        return data;

    }


}


