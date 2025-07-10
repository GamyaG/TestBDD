package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePO;

import java.time.Duration;

public class Tab extends BasePO {
    public void clickButton(String labelNameOrLocator) {
        WebElement element = getTabByLabel(labelNameOrLocator, false, 1);

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
    private WebElement getTabByLabel(String labelNameOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                xPathLocator = String.format("(//div[@role='tab' and contains(., \"%s\")])[%d]", labelNameOrLocator, index);
            }
            System.out.println("Tab xpath: " + xPathLocator);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
            return element;
        } catch (Exception ex) {
            ex.printStackTrace();  // Optional: Print the exception stack trace for debugging.
            return null;
        }
    }
}
