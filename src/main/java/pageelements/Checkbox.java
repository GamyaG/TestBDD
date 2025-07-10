package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;

import java.time.Duration;

public class Checkbox extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(Checkbox.class);


    public void selectCheckbox(String labelnameorlocator) {
        WebElement element = getCheckboxByLabel(labelnameorlocator, false,1);

        if (element != null) {
            waitFor(element);
                if (!element.isSelected()) {
                    waitForWebElementAndClick(element);
                    logger.info("Checkbox selected with locator '{}'", labelnameorlocator);
                }

        }
    }

    public boolean verifyCheckboxSelection(String labelnameorlocator, boolean expectedResult, boolean isLocator, int index) {
        WebElement element = getCheckboxByLabel(labelnameorlocator, isLocator, index);
        String selection = element.getAttribute("checked") == null ? "false" : "true";

        if (Boolean.parseBoolean(selection) == expectedResult) {
            logger.info("'{}' Checkbox validation success", labelnameorlocator);
            return true;
        } else {
            logger.info("'{}' Checkbox validation is not successful", labelnameorlocator);
            return false;
        }
    }

    public boolean verifyCheckboxExist(String labelnameorlocator, boolean isLocator, int index) {
        WebElement element = getCheckboxByLabel(labelnameorlocator, isLocator, index);

        if (element != null) {
            logger.info("'{}' Checkbox exists", labelnameorlocator);
            return true;
        } else {
            logger.info("'{}' Checkbox does not exist", labelnameorlocator);
            return false;
        }
    }

    private WebElement getCheckboxByLabel(String labelnameorlocator, boolean isLocator, int index) {
        String xPathLocator;
        WebDriverWait wait=  new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelnameorlocator, index);
            } else {
                xPathLocator = String.format("(//div[contains(text(),'%s')]/parent::div//div[@role='checkbox'])[%d]", labelnameorlocator, index);
            }
            System.out.println("Checkbox xpath locator "+ xPathLocator);

            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements. {}", labelnameorlocator, ex.getMessage());

            return null;
        }
    }
    public void selectElementCheckBox(String label) {
        WebElement element = getDriver().findElement(By.xpath("//label[text()='" + label + "']/../following-sibling::div//input[@type='checkbox']"));
        element.click();
    }

}
