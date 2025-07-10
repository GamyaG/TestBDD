package pageobjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

public class BasePO {
      public BasePO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    public String getUrl()
    {
       return getDriver().getCurrentUrl();
    }

    public void navigateToURL(String url) {
        getDriver().get(url);
    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(textToType);
    }

    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForWebElementAndClick(WebElement element) {
     WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAlertAndValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessageText = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessageText, text);
    }

    public void verifyText(WebElement element,String text)
    {
        String textElement= element.getText();
        Assert.assertEquals(textElement,text);
    }
    public void waitForInvisibleElement()
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class=\"gw-click-overlay gw-disable-click\"]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"gw-click-overlay\"]")));
    }
    public void waitForAlert(int duration)
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void setDropdownField(WebElement element,String value)  {
          try {
              WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
              wait.until(ExpectedConditions.elementToBeClickable(element)).click();
              element.clear();
              element.sendKeys("");
              element.sendKeys(value);
              Thread.sleep(2000);
              element.sendKeys(Keys.TAB);
              String enteredValue = element.getAttribute("value");
              if (enteredValue == null || enteredValue.isEmpty()) {
                  Thread.sleep(2000);
                  element.sendKeys(value);
              }
          }
          catch (Exception e) {
              e.printStackTrace();
          }



    }
    public void setInputField(WebElement element,String value) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            element.clear();
            element.sendKeys("");
            element.sendKeys(value);
            element.sendKeys(Keys.TAB);
            String enteredValue = element.getAttribute("value");
            if (enteredValue == null || enteredValue.isEmpty()) {
                Thread.sleep(2000);
                element.sendKeys(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickButton(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        if (element != null) {
            try {
                element.click();
            } catch (Exception e) {
                try {
                    Thread.sleep(3000);
                    element.click();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                }
            }
        }
    }

}
