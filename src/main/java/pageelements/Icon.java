package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;

import java.time.Duration;

public class Icon extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(Icon.class);
    public void clickSearchIcon(String labelnameorlocator) {
        WebElement element = getIconByLabel(labelnameorlocator, false, 1);

        if (element != null) {
            element.click();
            logger.info("Icon click performed with value '{}' on Button field with locator '{}'",  labelnameorlocator);
        }
    }

    public boolean verifyIconExist(String labelnameorlocator, boolean isLocator, int index) {
        WebElement element = getIconByLabel(labelnameorlocator, isLocator, index);

        if (element != null) {
            logger.info("'{}' Icon exists", labelnameorlocator);
            return true;
        } else {
            logger.info("'{}' Icon does not exist", labelnameorlocator);
            return false;
        }
    }

    private WebElement getIconByLabel(String labelnameorlocator, boolean isLocator, int index) {
        String xPathLocator;
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelnameorlocator, index);
            } else {
               xPathLocator = String.format("(//div[./div[normalize-space(text())='Sub #']]//div[@role='button' and ./span[@class='gw-icon']])[%d]", index);

            }
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements. {}", labelnameorlocator, ex.getMessage());
            return null;
        }
    }

    public enum ActionType {
        Click,
        Hover
    }
}
