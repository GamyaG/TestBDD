package stepDefinitions.base;

import com.github.javafaker.Faker;
import io.cucumber.java.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CommonFunctions;
import utils.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import static driver.DriverFactory.*;

public class Hooks {
    Faker faker = new Faker();
    CommonFunctions commonFunctions;
    MavenXpp3Reader reader = new MavenXpp3Reader();
    Model model = reader.read(new FileReader("pom.xml"));
    long startTime;
    Instant start ;
    String URL =null;
    private ScreenshotUtil screenshotUtil;

    public Hooks(CommonFunctions commonFunctions) throws XmlPullParserException, IOException {
        this.commonFunctions=commonFunctions;
        this.screenshotUtil = new ScreenshotUtil(getDriver());this.screenshotUtil = new ScreenshotUtil(getDriver());
    }
    @Before
    public void setup(Scenario scenario) {
        getDriver();
        commonFunctions.setTCIDFromScenario(scenario);


         start = Instant.now();
        CustomAppender.clearLogs();

    }
    @BeforeStep
    public void getUrl()
    {
        URL= getDriver().getCurrentUrl().trim();
        commonFunctions.setTestDataFileBasedOnUrl(URL);
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {

            if (scenario.isFailed()) {
                try{
                    String logDetails = String.join("\n", CustomAppender.getLogs());
                    String logText = "<details><summary>Step Details</summary><pre>" +logDetails + "</pre></details><br>";
                    String screenshotPath = screenshotUtil.takeScreenshot(scenario.getName());
                    File screenshotFile = new File(screenshotPath);
                    String image="<img data-featherlight="+"'"+"../screenshots/" + screenshotFile.getName()+"'"+"src="+" '"+"../screenshots/" + screenshotFile.getName() +" '"+">";
                    scenario.log(logText);
                    scenario.log(image);
                    CustomAppender.clearLogs();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    String screenshotPath = screenshotUtil.takeScreenshot(scenario.getName());
                    File screenshotFile = new File(screenshotPath);
                    String logDetails = String.join("\n", CustomAppender.getLogs());
                    String logText = "<details><summary>Step Details</summary><pre>" +logDetails+ "</pre></details><br>";
                    String image="<img data-featherlight="+"'"+"../screenshots/" + screenshotFile.getName()+"'"+"src="+" '"+"../screenshots/" + screenshotFile.getName() +" '"+">";
                    scenario.log(logText);
                    scenario.log(image);
                    CustomAppender.clearLogs();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        String fullFeatureName = FilenameUtils.getName(scenario.getUri().toString());
        int dotIndex = fullFeatureName.indexOf('.');
        String Feature_name = dotIndex != -1 ? fullFeatureName.substring(0, dotIndex) : fullFeatureName;
        Saves save= new Saves();
        save.id=0;
        save.runID= 0;
        save.projectName= model.getArtifactId().trim();
        save.environment=TestRunConfig.ENV;
        save.featureName=Feature_name;
        save.sceenarioName=scenario.getName();
        save.executedDateTime = ZonedDateTime.now(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX"));
        save.result="Passed";
        save.machineName=System.getProperty("os.name");
        save.executedBy=System.getProperty("user.name");
        save.executionType="Automation";
        save.tags= scenario.getSourceTagNames().stream()
                .findFirst()
                .orElse("")  // Get the first tag if present, otherwise return an empty string
                .replaceAll("@", "");
        save.failureReason= "";
        save.category="";
        save.sprintName="";
        save.duration= String.format("%02d:%02d:%02d.%04d",timeElapsed.toDays(),timeElapsed.toHours(),timeElapsed.toMinutes(),timeElapsed.getSeconds());
        save.releaseLink=System.getenv("RELEASE_RELEASEWEBURL");
        System.out.println(save);
        SaveTestResults savesresult=new SaveTestResults();
        boolean save_success=savesresult.SaveResults(save);
        if(save_success)
        {
            System.out.println("Results Saved successfully");
        }
        else
        {
            System.out.println("Failed to save test results");
        }
       cleanupDriver();
    }
}

