package runners;

import io.cucumber.testng.*;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.RetryAnalyzer;
import utils.TestRunConfig;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CucumberOptions(tags = "@TC_101_bind_submission_GCP",
        plugin = {"pretty", "html:target/cucumber/report.html",
                "json:target/cucumber/report.json",
                "junit:target/cucumber-results.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failedrerun.txt"
        },
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        dryRun = false,
        monochrome = true)
public class MainRunner extends AbstractTestNGCucumberTests {
    private static final Logger log = LoggerFactory.getLogger(MainRunner.class);
    private TestNGCucumberRunner testNGCucumberRunner;
    private static final String THREAD_COUNT_KEY = "dataproviderthreadcount";
    private static final String THREAD_COUNT_VALUE = TestRunConfig.THREAD_COUNT;
    private static final boolean isParallel = true;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.setProperty(THREAD_COUNT_KEY, THREAD_COUNT_VALUE);
        try {
            if (!System.getProperty("os.name").toLowerCase().contains("linux"))
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    @Override
    @DataProvider(parallel = isParallel)
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
    @AfterSuite
    public void extentReport() {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yy_HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        File renameHtmlfile = new File("reports" + File.separator + "Spark"+ "-"+actualDate + ".html");
        File html=new File("reports" + File.separator +  "spark.html");
        html.renameTo(renameHtmlfile);
    }

    @AfterClass(alwaysRun = true)
    public void testDownClass() throws IOException {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
        File cucumberJsonFile = new File("target/cucumber/report.json");
        File encodedStrFile = new File("target/encoded_cucumber_json.txt");
        encodedStrFile.createNewFile();
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        String projectName = "N&D";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("Environment", TestRunConfig.ENV);
        configuration.addClassifications("Browser", TestRunConfig.GET_BROWSER);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        jsonFiles.add("target/cucumber/report.json");
        reportBuilder.generateReports();

    }
}
