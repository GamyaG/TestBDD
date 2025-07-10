package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;

import java.time.Duration;

public class Label extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(Icon.class);
    public boolean verifyPolicyNumberText(String expectedValue) {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='policyNumberMoreInfo']")));
            String result = element.getText();
            return result.equals(expectedValue);
        } catch (Exception e) {
            logger.error("Error verifying policy number text", e);
            return false;
        }
    }

    public String getPolicyNumberText() {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//strong[text()='Auto Policies Purchased']//following::span[1]")));
            return element.getText();
        } catch (Exception e) {
            logger.error("Error getting policy number text", e);
            return null;
        }
    }

    public boolean verifyLabelExist(String labelnameorlocator, boolean isLocator, int index) {
        WebElement element = getLabelFieldByLabel(labelnameorlocator, isLocator, index);

        if (element != null) {
            logger.info("'{}' Label exists", labelnameorlocator);
            return true;
        } else {
            logger.info("'{}' Label does not exist", labelnameorlocator);
            return false;
        }
    }

    private WebElement getLabelFieldByLabel(String labelnameorlocator, boolean isLocator, int index) {
        String xPathLocator;
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelnameorlocator, index);
            } else {
                xPathLocator = String.format("(//*[normalize-space(text())='%s'])[%d]", labelnameorlocator, index);
            }

            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathLocator)));
        } catch (Exception e) {
            logger.error("Error: Element locator '{}' did not match any elements.", labelnameorlocator, e);
            return null;
        }
    }
    public String waitForScreenHeading(String labelOrLocator) {
        WebElement headingElement = getScreenHeading(labelOrLocator, false, 1);

        if (headingElement != null && headingElement.isDisplayed()) {
            waitFor(headingElement);
            logger.info("Successfully waited for screen heading '{}'.", labelOrLocator);
           return headingElement.getText();

        } else {
            logger.error("Screen heading '{}' was not found.", labelOrLocator);
        }
        return labelOrLocator;
    }

    private WebElement getScreenHeading(String labelOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

        try {
            if (isLocator) {
                // If 'isLocator' is true, assume the provided string is an XPath expression.
                xPathLocator = String.format("(%s)[%d]", labelOrLocator, index);
            } else {
                // Create an XPath to locate headings that match the text.
                xPathLocator = String.format("(//div[@role='heading' and contains(.,'%s')])[%d]", labelOrLocator, index);
            }

            // Wait until the heading element is visible and return it.
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathLocator)));
        } catch (Exception e) {
            logger.error("Error: Element with locator '{}' was not found.", labelOrLocator, e);
            return null;
        }
    }


}
