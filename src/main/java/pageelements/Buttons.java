package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePO;

import java.time.Duration;

public class Buttons extends BasePO {
    public void clickButton(String labelNameOrLocator) {
        WebElement element = getButtonByLabel(labelNameOrLocator, false, 1);

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

    private WebElement getButtonByLabel(String labelNameOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                xPathLocator = String.format("(//div[@role='button' and contains(., \"%s\")])[%d]", labelNameOrLocator, index);
            }
            System.out.println("ButtonXpath: " + xPathLocator);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
            return element;
        } catch (Exception ex) {
            ex.printStackTrace();  // Optional: Print the exception stack trace for debugging.
            return null;
        }
    }
    public void clickTableButton(String labelNameOrLocator) {

        WebElement element = getTableButtonByLabel(labelNameOrLocator,false, 1);

        if (element != null) {
            try {
                // Wait until the element is clickable
                waitFor(element);
                element.click();
            } catch (Exception e) {
                // Retry logic with WebDriverWait instead of Thread.sleep
                try {
                    waitFor(element);
                    Thread.sleep(3000);
                    element.click(); // Try clicking again
                } catch (Exception retryException) {
                    retryException.printStackTrace(); // Log or handle the retry failure
                }
            }
        }
    }
    private WebElement getTableButtonByLabel(String labelNameOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                xPathLocator = String.format("//td[contains(., '%s')]/preceding-sibling::td//div[@role='button' and contains(., 'Select')][%d]", labelNameOrLocator, index);
            }

            System.out.println("ButtonXpath: " + xPathLocator);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            return element;
        } catch (Exception ex) {
            ex.printStackTrace();  // Optional: Print the exception stack trace for debugging.
            return null;
        }
    }
    public void clickDropdownIconButton(String labelNameOrLocator) {

        WebElement element = getDropdownButtonByLabel(labelNameOrLocator,false, 1);

        if (element != null) {
            try {
                // Wait until the element is clickable
                waitFor(element);
                element.click();
            } catch (Exception e) {
                // Retry logic with WebDriverWait instead of Thread.sleep
                try {
                    waitFor(element);
                    Thread.sleep(3000);
                    element.click(); // Try clicking again
                } catch (Exception retryException) {
                    retryException.printStackTrace(); // Log or handle the retry failure
                }
            }
        }
    }
    private WebElement getDropdownButtonByLabel(String labelNameOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                xPathLocator = String.format("//div[@aria-label='%s']/parent::div/following-sibling::div[contains(@class, 'gw-action--expand-button')][%d]", labelNameOrLocator, index);
            }
            System.out.println("ButtonXpath: " + xPathLocator);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
            return element;
        } catch (Exception ex) {
            ex.printStackTrace();  // Optional: Print the exception stack trace for debugging.
            return null;
        }
    }
    public void verifyScreen(String labelNameOrLocator) {
        WebElement element = getScreenByLabel(labelNameOrLocator, false, 1);
        if (element != null) {
            waitFor(element);
        }
    }

    private WebElement getScreenByLabel(String labelNameOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        try {
            if (isLocator) {
                // If labelNameOrLocator is already a locator
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                // If it's a label name, construct the XPath based on text
                xPathLocator = String.format("(//div[@role='heading' and contains(.,'%s')])[%d]", labelNameOrLocator, index);
            }
            System.out.println("ScreenXpath: " + xPathLocator);

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathLocator)));
            return element;
        } catch (Exception ex) {
            ex.printStackTrace();  // Optional: Print the exception stack trace for debugging.
            return null;
        }
    }






}
