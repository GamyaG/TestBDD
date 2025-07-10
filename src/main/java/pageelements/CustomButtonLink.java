package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;

import java.time.Duration;

public class CustomButtonLink extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(Checkbox.class);
    public void clickCustomButtonLink(String labelnameorlocator, boolean isLocator, int index) {
        WebElement element = getCustomButtonLinkByLabel(labelnameorlocator, isLocator, index);

        if (element != null) {
            element.click();
            logger.info("Button click performed with value '{}' on Button field with locator '{}'", labelnameorlocator);
        }
    }

    public boolean verifyCustomButtonLinkExist(String labelnameorlocator, boolean isLocator, int index) {
        WebElement element = getCustomButtonLinkByLabel(labelnameorlocator, isLocator, index);

        if (element != null) {
            logger.info("'{}' button exists", labelnameorlocator);
            return true;
        } else {
            logger.info("'{}' button does not exist", labelnameorlocator);
            return false;
        }
    }

    private WebElement getCustomButtonLinkByLabel(String labelnameorlocator, boolean isLocator, int index) {
        String xPathLocator;
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelnameorlocator, index);
            } else {
                xPathLocator = String.format("(//div[(@role='link') or (@role='button')]/descendant-or-self::*[normalize-space(text())=\"%s\"])[%d]", labelnameorlocator, index);
            }

            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements. {}", labelnameorlocator, ex.getMessage());
            return null;
        }
    }
}
