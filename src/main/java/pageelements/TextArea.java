package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;

import java.time.Duration;

public class TextArea extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(DatePicker.class);
    public void setTextAreaField(String labelnameorlocator, String value) {
        WebElement element = getTextAreaFieldByLabel(labelnameorlocator, false, 1);
        if (element != null) {
            element.click();
            element.clear();
            element.sendKeys(value);
            logger.info("Entered value '{}' to Input field with locator '{}'", value, labelnameorlocator);
        }
    }

    public void setDOBField(String labelnameorlocator, String value, boolean isLocator, int index) {
        if (value != null && !value.isEmpty()) {
            WebElement element = getTextAreaFieldByLabel(labelnameorlocator, isLocator, index);
            if (element != null) {
                Actions actions = new Actions(getDriver());
                element.clear();
                actions.moveToElement(element).click().perform();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                actions.sendKeys(value).perform();
                logger.info("Entered value '{}' to Input field with locator '{}'", value, labelnameorlocator);
            }
        }
    }

    public void setCustomTextAreaField(String labelnameorlocator, String value, boolean isLocator, int index) {
        if (value != null && !value.isEmpty()) {
            WebElement element = getCustomTextAreaFieldByLabel(labelnameorlocator, isLocator, index);
            if (element != null) {
                Actions actions = new Actions(getDriver());
                element.clear();
                actions.moveToElement(element).click().perform();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                actions.sendKeys(value).perform();
                logger.info("Entered value '{}' to Input field with locator '{}'", value, labelnameorlocator);
            }
        }
    }

    public boolean verifyTextAreaFieldValue(String labelnameorlocator, String expectedText, boolean isLocator, int index) {
        WebElement element = getTextAreaFieldByLabel(labelnameorlocator, isLocator, index);
        if (element != null && expectedText.equals(element.getAttribute("value"))) {
            logger.info("'{}' Input field Validation success", labelnameorlocator);
            return true;
        } else {
            logger.info("'{}' Input field Validation is not successful", labelnameorlocator);
            return false;
        }
    }

    public boolean verifyTextAreaFieldExist(String labelnameorlocator, boolean isLocator, int index) {
        WebElement element = getTextAreaFieldByLabel(labelnameorlocator, isLocator, index);
        if (element != null) {
            logger.info("'{}' Text box exists", labelnameorlocator);
            return true;
        } else {
            logger.info("'{}' Text box does not exist", labelnameorlocator);
            return false;
        }
    }

    private WebElement getTextAreaFieldByLabel(String labelnameorlocator, boolean isLocator, int index) {
        String xPathLocator = "";
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelnameorlocator, index);
            } else {
                xPathLocator = String.format("(//*[normalize-space(text())='%s']//following::textarea)[%d]", labelnameorlocator, index);
            }
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements. {}", labelnameorlocator, ex);
            return null;
        }
    }

    private WebElement getCustomTextAreaFieldByLabel(String labelnameorlocator, boolean isLocator, int index) {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String xPathLocator = "";
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelnameorlocator, index);
            } else {
                xPathLocator = String.format("(//*[normalize-space(text())='%s']/../parent::div/following::textarea)[%d]", labelnameorlocator, index);
            }
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements. {}", labelnameorlocator, ex);
            return null;
        }
    }
}
