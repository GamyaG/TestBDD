package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageobjects.BasePO;

import java.time.Duration;

public class TextLink extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(DatePicker.class);
    public void clickTextLink(String labelnameorlocator) {
        try {
            WebElement element = getTextLinkByLabel(labelnameorlocator, false, 1);
            if (element != null) {
                element.click();
                Thread.sleep(1000);
                logger.info("TextLink click performed on TextLink field with locator '{}'", labelnameorlocator);
            }
        } catch (Exception ex) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            logger.error("Error clicking TextLink with locator '{}': {}", labelnameorlocator, ex.getMessage());
        }
    }

    public String verifyTextLinkExist(String labelnameorlocator) {
        WebElement element = getTextLinkByLabel(labelnameorlocator, false, 1);
        if (element != null) {
            Assert.assertTrue(element.isDisplayed());
            logger.info("'{}' Text link exists", labelnameorlocator);
            return element.getText();
        } else {
            logger.warn("'{}' Text link does not exist", labelnameorlocator);
            return "";  // Return an empty string or handle it appropriately
        }
    }


    private WebElement getTextLinkByLabel(String labelnameorlocator, boolean isLocator, int index) {
        String xPathLocator;
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            if (isLocator) {
                xPathLocator = String.format("(%s)[%d]", labelnameorlocator, index);
            } else {
                xPathLocator = String.format("(//div[@role='link' and contains(., '%s')])[%d]", labelnameorlocator, index);
            }
            System.out.println("TextLink :"+xPathLocator);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements.", labelnameorlocator, ex);
            return null;
        }
    }
    public void ClickLinkByLinkText(String linkText)
    {
        getDriver().findElement(By.linkText(linkText)).click();
    }
}
