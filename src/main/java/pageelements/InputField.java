package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;
import utils.Global_Vars;

import java.time.Duration;

public class InputField extends BasePO {

    private WebDriverWait wait;
    private static final String ATTRIBUTE_VALUE = "value";
    private static final Logger log = LoggerFactory.getLogger(InputField.class);

    public InputField() {
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
    }

    public void setInputField(String labelNameOrLocator, String value) {
        WebElement element = getInputFieldByLabel(labelNameOrLocator, false, 1);
        if (element != null) {
            waitFor(element);
            element.clear();
            setElementValue(element, value);
            log.info("Entered value '{}' to Input field with locator '{}'", value, labelNameOrLocator);
        } else {
            log.error("Element not found for locator: '{}'", labelNameOrLocator);
        }
    }

    private WebElement getInputFieldByLabel(String labelNameOrLocator, boolean isLocator , int index) {
        String xPathLocator = isLocator
                ? String.format("(%s)[%d]", labelNameOrLocator, index)
                : String.format("(//div[normalize-space(text())='%s']/following-sibling::div//input)[%d]", labelNameOrLocator, index);


        System.out.println(xPathLocator);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            log.error("Error: Element locator '{}' did not match any elements. {}", labelNameOrLocator, ex);
            return null;
        }
    }


    private void setElementValue(WebElement element, String value) {
        element.clear();
        element.sendKeys("");
        element.sendKeys(value);
        element.sendKeys(Keys.TAB);

        String enteredValue = element.getAttribute(ATTRIBUTE_VALUE);
        if (enteredValue == null || enteredValue.isEmpty()) {
            sleepWithInterruptHandling(2000);
            element.clear();
            element.sendKeys(value);
        }
    }


    private void sleepWithInterruptHandling(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("Interrupted Exception: {}", e.getMessage());
        }
    }
    public void setLimitInputField(String labelNameOrLocator, String value) {
        WebElement element = getInputFieldLimitdByLabel(labelNameOrLocator, false, 1);
        if (element != null) {
            waitFor(element);
            element.clear();
            setElementValue(element, value);
            log.info("Entered value '{}' to Input field with locator '{}'", value, labelNameOrLocator);
        } else {
            log.error("Element not found for locator: '{}'", labelNameOrLocator);
        }
    }

    private WebElement getInputFieldLimitdByLabel(String labelNameOrLocator, boolean isLocator , int index) {
        String xPathLocator = isLocator
                ? String.format("(%s)[%d]", labelNameOrLocator, index)
                : String.format("(//div[contains(@aria-label, '%s')]//div[./div[normalize-space(text())='Limit']]//input)[%d]", labelNameOrLocator, index);


        System.out.println(xPathLocator);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            log.error("Error: Element locator '{}' did not match any elements. {}", labelNameOrLocator, ex);
            return null;
        }
    }
    public void setDeductibleInputField(String labelNameOrLocator, String value) {
        WebElement element = getInputFieldDeductibleByLabel(labelNameOrLocator, false, 1);
        if (element != null) {
            waitFor(element);
            element.clear();
            setElementValue(element, value);
            log.info("Entered value '{}' to Input field with locator '{}'", value, labelNameOrLocator);
        } else {
            log.error("Element not found for locator: '{}'", labelNameOrLocator);
        }
    }

    private WebElement getInputFieldDeductibleByLabel(String labelNameOrLocator, boolean isLocator , int index) {
        String xPathLocator = isLocator
                ? String.format("(%s)[%d]", labelNameOrLocator, index)
                : String.format("(//div[contains(@aria-label, '%s')]//div[./div[normalize-space(text())='Deductible']]//input)[%d]", labelNameOrLocator, index);


        System.out.println(xPathLocator);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            log.error("Error: Element locator '{}' did not match any elements. {}", labelNameOrLocator, ex);
            return null;
        }
    }


}
