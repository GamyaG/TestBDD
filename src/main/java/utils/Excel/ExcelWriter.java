package utils.Excel;

    import org.apache.poi.xssf.usermodel.XSSFCell;
    import org.apache.poi.xssf.usermodel.XSSFRow;
    import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    import java.io.FileInputStream;
    import java.io.FileOutputStream;
import java.io.IOException;

    public class ExcelWriter {
        public XSSFRow Row;
        public XSSFCell Cell;
        XSSFWorkbook workbook;
        XSSFSheet sheet;

        public ExcelWriter() throws IOException {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JagadeshKoduru\\BDD_Main\\src\\main\\resources\\WorkBook\\CAuto.xlsx"); // Specify the existing Excel file
            workbook = new XSSFWorkbook(fileInputStream); // Use XSSFWorkbook for .xlsx files
             sheet = workbook.getSheet("Sheet1");
        }

            public void Write_Premium(String Premium)throws IOException {



                int row_num=5;
               Row=sheet.getRow(row_num);
                Cell = Row.createCell(1); // Cell A1
                Cell.setCellValue(Premium);


                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\JagadeshKoduru\\BDD_Main\\src\\main\\resources\\WorkBook\\CAuto.xlsx");
                workbook.write(fileOutputStream);




            }
        }


