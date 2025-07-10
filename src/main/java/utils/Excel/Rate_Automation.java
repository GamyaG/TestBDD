package utils.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Rate_Automation {
    public XSSFRow Row;
    public XSSFCell Cell;

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    private Rate_Automation() {
        try(FileInputStream fis=new FileInputStream("src\\main\\resources\\WorkBook\\CAuto Rate Calculator_v1.5_Trimmed.xlsm")) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Test Data");
        }
        catch(IOException e){

        }
    }


    public String getCellData ( int rownum, int columnum) {

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

