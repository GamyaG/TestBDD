package pages;

import helper.ExcelReader;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import pageobjects.BasePO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
public class CommonFunctions extends BasePO {
//    private static final ThreadLocal<String> TestDataFile = ThreadLocal.withInitial(() -> {
//        Path currentDir = Paths.get("").toAbsolutePath();
//        return currentDir.toString() + File.separator + "Data" + File.separator + "GWTestData.xlsx";
//    });
//    private static final ThreadLocal<String> TCid = ThreadLocal.withInitial(() -> "");
//    public CommonFunctions() {
//
//    }
//    public void setTCIDFromScenario(Scenario scenario) {
//        TCid.set(scenario.getName());
//    }
//    public AbstractMap.SimpleEntry<String, String> getLabelAndValue(String pageName, String fieldName) throws IOException {
//        String testDataPath = TestDataFile.get(); // Get the thread-local TestDataFile
//        String testCaseId = TCid.get(); // Get the thread-local TCid
//        String labelName = ExcelReader.getCellDataLabelName(testDataPath, pageName, testCaseId, fieldName);
//        String labelValue = ExcelReader.getCellDataKeyValue(testDataPath, pageName, testCaseId, fieldName);
//        return new AbstractMap.SimpleEntry<>(labelName, labelValue);
//    }
private static final ThreadLocal<String> TestDataFile = new ThreadLocal<>();
    private static final ThreadLocal<String> TCid = ThreadLocal.withInitial(() -> "");

    // Constructor
    public CommonFunctions() {
    }

    // Method to set TCID from the scenario
    public void setTCIDFromScenario(Scenario scenario) {
        TCid.set(scenario.getName());
    }

  
    public void setTestDataFileBasedOnUrl(String url) {
        Path currentDir = Paths.get("").toAbsolutePath();
        String basePath = currentDir.toString() + File.separator + "Data" + File.separator;

        // Define the Excel files for different URLs/environments
        String excelFilePath;
        if (url.contains("PolicyCenter")) {
            excelFilePath = basePath + "GWTestData.xlsx";
        } else if (url.contains("BillingCenter")) {
            excelFilePath = basePath + "GWBCTestData.xlsx";
        } else if (url.contains("ClaimCenter")) {
            excelFilePath = basePath + "GWCCTestData.xlsx";
        } else {
            excelFilePath = basePath + "GWTestData_Default.xlsx"; // Default fallback
        }
        TestDataFile.set(excelFilePath);
    }

    public AbstractMap.SimpleEntry<String, String> getLabelAndValue(String pageName, String fieldName) throws IOException {
        String testDataPath = TestDataFile.get(); // Get the thread-local TestDataFile
        String testCaseId = TCid.get(); // Get the thread-local TCid
        // Read the label and value from the Excel file using ExcelReader
        String labelName = ExcelReader.getCellDataLabelName(testDataPath, pageName, testCaseId, fieldName);
        String labelValue = ExcelReader.getCellDataKeyValue(testDataPath, pageName, testCaseId, fieldName);
        return new AbstractMap.SimpleEntry<>(labelName, labelValue);
    }
}
