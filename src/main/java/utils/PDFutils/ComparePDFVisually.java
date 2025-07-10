package utils.PDFutils;
import de.redsix.pdfcompare.PdfComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.Excel.ExcelUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ComparePDFVisually {
    public static final Logger log = LoggerFactory.getLogger(ComparePDFVisually.class);
    static boolean isEquals = false;
    public static void main(String[]args){

        //String file1="C:/New folder/dummy.pdf";
        //String file2="C:/New folder/test.pdf";

        Scanner in=new Scanner(System.in);
        String file1=in.nextLine();
        String file2=in.nextLine();

        try{
            File f1 = new File(file1);
            File f2 = new File(file2);
         try {
                isEquals = new PdfComparator(f1, f2).compare().writeTo("C:\\New folder\\result");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!isEquals) {
                throw new Exception("Differences Found in provided files "+file1+ "and "+file2);
            }
            if (isEquals) {
                log.info("Differences not found");
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}