package utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageobjects.BasePO;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenshotUtil extends BasePO {

    private WebDriver driver;
    private static final String SCREENSHOT_FOLDER = "screenshots/";

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
        createScreenshotFolder();
    }

    private void createScreenshotFolder() {
        File dir = new File(SCREENSHOT_FOLDER);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    public String takeScreenshot(String screenshotName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = SCREENSHOT_FOLDER +"_" + timestamp + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(filePath).getCanonicalPath();
    }
}


