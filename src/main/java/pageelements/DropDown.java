package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class DropDown extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(DropDown.class);

    // Select a dropdown value
    public void selectDropDown(String labelNameOrLocator, String value) {
            // Locate the dropdown element
            WebElement element = getDropDownByLabel(labelNameOrLocator, false, 1);
            waitFor(element); // Wait until the element is ready

            if (element != null) {
                // Create a Select object for the dropdown
                Select currentElement = new Select(element);
                currentElement.selectByVisibleText(value); // Attempt to select the value
                // Verify the value was successfully selected
            }
    }
    public void selectDropDownByIndex(String labelNameOrLocator, int value) {
        // Locate the dropdown element
        WebElement element = getDropDownByLabel(labelNameOrLocator, false, 1);
        waitFor(element); // Wait until the element is ready

        if (element != null) {
            // Create a Select object for the dropdown
            Select currentElement = new Select(element);
            currentElement.selectByIndex(value); // Attempt to select the value
            // Verify the value was successfully selected
        }
    }
    public void selectLimitDropDown(String labelNameOrLocator, String value) {
        // Locate the dropdown element
        WebElement element = getLimitDropDownByLabel(labelNameOrLocator, false, 1);
        waitFor(element); // Wait until the element is ready

        if (element != null) {
            // Create a Select object for the dropdown
            Select currentElement = new Select(element);
            currentElement.selectByVisibleText(value); // Attempt to select the value
            // Verify the value was successfully selected
        }
    }


    // Verify the selected dropdown value
    public boolean verifyDropDownValue(String labelNameOrLocator, String value, boolean isLocator, int index) {
        WebElement element = getDropDownByLabel(labelNameOrLocator, isLocator, index);

        if (element != null) {
            Select currentElement = new Select(element);
            String selectedValue = currentElement.getFirstSelectedOption().getText();

            if (selectedValue.equals(value)) {
                logger.info("Value '{}' is selected in '{}' dropdown", value, labelNameOrLocator);
                return true;
            } else {
                logger.info("Value '{}' is NOT selected in '{}' dropdown", value, labelNameOrLocator);
                return false;
            }
        }
        return false;
    }

    // Verify dropdown values
    public void verifyDropDownValues(String labelNameOrLocator, String expectedList, boolean isLocator) {
        String[] options = expectedList.split("\\|");
        List<String> optionList = Arrays.asList(options);

        List<WebElement> dropdownList = getDropDownOptionsByLabel(labelNameOrLocator, isLocator);
        StringBuilder missingOptions = new StringBuilder();

        if (dropdownList != null) {
            for (String option : optionList) {
                if (dropdownList.stream().noneMatch(e -> e.getText().equals(option))) {
                    missingOptions.append(option).append("|");
                }
            }

            if (missingOptions.length() > 0) {
                logger.info("Drop down options '{}' are not found in '{}' dropdown", missingOptions, labelNameOrLocator);
            } else {
                logger.info("All options '{}' are found in '{}' dropdown", expectedList, labelNameOrLocator);
            }
        }
    }

    // Check if dropdown exists
    public boolean verifyDropDownExist(String labelNameOrLocator, boolean isLocator, int index) {
        WebElement element = getDropDownByLabel(labelNameOrLocator, isLocator, index);

        if (element != null) {
            logger.info("'{}' Drop down exists", labelNameOrLocator);
            return true;
        } else {
            logger.info("'{}' Drop down does not exist", labelNameOrLocator);
            return false;
        }
    }

    // Get list of dropdown options by label
    private List<WebElement> getDropDownOptionsByLabel(String labelNameOrLocator, boolean isLocator) {
        String xPathLocator;

        try {
            if (isLocator) {
                xPathLocator = String.format("%s//option", labelNameOrLocator);
            } else {
                xPathLocator = String.format("(//div[normalize-space(text())='%s']/following-sibling::div//select)[1]//option", labelNameOrLocator);
            }
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathLocator)));

            // Return list of options in the select element
            return element.findElements(By.tagName("option"));

        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage());
            return null;
        }
    }

    // Get dropdown element by label
    private WebElement getDropDownByLabel(String labelNameOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                xPathLocator = String.format("(//div[normalize-space(text())='%s']/following-sibling::div//select)[%d]", labelNameOrLocator, index);
            }
            System.out.println(xPathLocator);

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathLocator)));
            wait.until(ExpectedConditions.visibilityOf(element));

            return element;
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements. {}", labelNameOrLocator, ex.getMessage());
            return null;
        }
    }
    private WebElement getLimitDropDownByLabel(String labelNameOrLocator, boolean isLocator, int index) {
        String xPathLocator;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                xPathLocator = String.format("(//div[contains(@aria-label, '%s')]//div[./div[normalize-space(text())='Limit']]//input)[%d]", labelNameOrLocator, index);
            }
            System.out.println(xPathLocator);

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathLocator)));
            wait.until(ExpectedConditions.visibilityOf(element));

            return element;
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements. {}", labelNameOrLocator, ex.getMessage());
            return null;
        }
    }
}
