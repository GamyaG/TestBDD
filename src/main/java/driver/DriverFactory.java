package driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.TestRunConfig;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    private static final Logger log=LoggerFactory.getLogger(DriverFactory.class);
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
 private DriverFactory(){

 }

    public static WebDriver getDriver(){
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver(){
        WebDriver driver = null;
        String browserType = TestRunConfig.BROWSER;
        if (browserType == null) {
            throw new RuntimeException("Browser type is not specified or is invalid.");

        }
        switch (browserType) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new"); // 👈 safer modern headless mode
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--remote-allow-origins=*");

                WebDriverManager.chromedriver().setup();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(80));
                driver.manage().window().maximize();
            }
            case "remote-chrome" -> {
                try {
                    String huburl ="https://selenium-hub.ashyhill-0742ba8d.eastus2.azurecontainerapps.io/wd/hub";// Update with your actual hub URL
                    System.out.println(huburl);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    // Setup WebDriverManager with specified Chrome version

                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    driver = new RemoteWebDriver(new URL(huburl), capabilities);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                    driver.manage().window().maximize();
                } catch (MalformedURLException e) {
                    log.error("Invalid Remote WebDriver URL", e);
                }
            }
             case"headless-chrome-remote" ->{
                 //String huburl ="https://selenium-hub.ashyhill-0742ba8d.eastus2.azurecontainerapps.io/wd/hub";
                //String huburl="https://automationexecution-hub.icybeach-ff2d1f61.eastus.azurecontainerapps.io/wd/hub";
                String huburl=TestRunConfig.REMOTE_HUB_URL;
                // Update with your actual hub URL
                System.out.println("HUB:"+huburl);
                ChromeOptions options = new ChromeOptions();
                 options.addArguments("--remote-allow-origins=*");
                 // Setup WebDriverManager with specified Chrome version

                 options.addArguments("--headless");  // Run in headless mode
                 options.addArguments("--disable-gpu");  // Disable GPU to avoid GPU-related crashes
                 options.addArguments("--no-sandbox");  // Disable sandboxing for containerized environments
                 options.addArguments("--disable-dev-shm-usage");  // Use /dev/shm for more shared memory
                 options.addArguments("--disable-extensions");  // Disable extensions
                 //options.addArguments("--remote-debugging-port=9222");  // Enable remote debugging
                 options.addArguments("--window-size=1920,1080");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                try {// Initialize RemoteWebDriver with hub URL and capabilities
                     driver = new RemoteWebDriver(new URL(huburl), capabilities);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                    driver.manage().window().maximize();
                    System.out.println("Remote Driver launched successfully");
                }
             catch (Exception e) {
                    System.out.println("Error occurred while initializing RemoteWebDriver: " + e.getMessage());
                }
            }
            case "headless-chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();

                // Necessary arguments for headless mode
                chromeOptions.addArguments("--remote-allow-origins=*");
                // Setup WebDriverManager with specified Chrome version

                chromeOptions.addArguments("--headless"); // Run Chrome in headless mode
                chromeOptions.addArguments("--disable-gpu"); // Disable GPU (helps in some environments)
                chromeOptions.addArguments("--window-size=1920,1080"); // Set window size
                chromeOptions.addArguments("--ignore-certificate-errors"); // Ignore SSL certificate errors

                // Set up ChromeDriver using WebDriverManager
                WebDriverManager.chromedriver().setup();

                // Set the page load strategy
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                // Initialize the ChromeDriver with the ChromeOptions
                driver = new ChromeDriver(chromeOptions);

                // Set timeouts
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(400));

                // Maximize window (this won't have much effect in headless mode but keeping it for future non-headless use)
                driver.manage().window().maximize();
            }

            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);

            }
            case "remote" -> {
                String huburl =System.getenv("HUBURL");
                log.info(huburl);
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setPlatform(Platform.LINUX); //cap.setPlatform(Platform.MAC);
                cap.setBrowserName("chrome");
                try {
                    driver = new RemoteWebDriver(new URL(huburl), cap);
                    driver.manage().window().maximize();
                }
                catch(Exception e){
                    e.getMessage();
                }
            }
            case "bschromeandroid" -> {
                try {
                    final String AUTOMATE_USERNAME = TestRunConfig.BS_USERNAME;
                    final String AUTOMATE_ACCESS_KEY = TestRunConfig.BS_ACCESSKEY;
                    final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability("browserName", TestRunConfig.BS_BROWSERNAME);
                    caps.setCapability("device", TestRunConfig.BS_DEVICE);
                    caps.setCapability("realMobile", "true");
                    caps.setCapability("os_version", TestRunConfig.BS_OSVERSION);
                    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
                    caps.setCapability("build", "BStack Build Number Test");
                    driver = new RemoteWebDriver(new URL(URL), caps);
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }

            }
            case "edge" -> {
                try {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(edgeOptions);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                    driver.manage().window().maximize();

                }
                catch(WebDriverException e){
                    log.error(e.getMessage());
                }
            }
            default->
                    log.info("Browsertyp_not_found");
        }


        if (driver != null) {
            driver.manage().window().maximize();  // Perform operations on the driver only if it's not null
        } else {
            throw new RuntimeException("Failed to create WebDriver instance");
        }
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;
        Properties properties = new Properties();
        try( FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");) {
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return browserType;
    }


    public static void cleanupDriver() {
       if (webDriver.get() != null) {
        try {
            webDriver.get().close();  // Close the current browser window
            webDriver.get().quit();   // Quit the driver instance
        } catch (Exception e) {
            log.error("Error while closing the driver: " + e.getMessage());
        } finally {
            webDriver.remove();  // Remove the driver from ThreadLocal storage
        }
       }
    }

}
