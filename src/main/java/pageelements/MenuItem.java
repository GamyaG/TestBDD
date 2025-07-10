package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;

import java.time.Duration;

public class MenuItem extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(MenuItem.class);

    public void clickMenuItem(String labelNameOrLocator) {
        WebElement element = getMenuItemByLabel(labelNameOrLocator, false, 1);

        if (element != null) {
            try {
                // Wait until the element is clickable
                waitFor(element);
                element.click();
            } catch (Exception e) {
                // Retry logic with WebDriverWait instead of Thread.sleep
                try {
                    waitFor(element);
                    Thread.sleep(2000);
                    element.click(); // Try clicking again
                } catch (Exception retryException) {
                    retryException.printStackTrace(); // Log or handle the retry failure
                }
            }
        }
    }

    public boolean verifyMenuItem(String labelNameOrLocator) {
        WebElement element = getMenuItemByLabel(labelNameOrLocator, false, 1);

        if (element != null) {
            logger.info("Menu item '{}' exists", labelNameOrLocator);
            return true;
        } else {
            logger.warn("Menu item '{}' does not exist", labelNameOrLocator);
            return false;
        }
    }

    private WebElement getMenuItemByLabel(String labelNameOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                // Use the refined XPath to target the specific menu item based on aria-label
                xPathLocator = String.format("(//div[@role='menuitem' and div[@aria-label='%s']])[%d]", labelNameOrLocator, index);
            }
            System.out.println("MenuitemXpath: " + xPathLocator);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
            return element;
        } catch (Exception ex) {
            ex.printStackTrace();  // Optional: Print the exception stack trace for debugging.
            return null;
        }
    }
}
