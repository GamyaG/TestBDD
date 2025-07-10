package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BasePO;

import java.time.Duration;

public class RadioButton extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(RadioButton.class);
    public void selectRadioButton(String labelnameorlocator, String value) {
        WebElement element = getRadioButtonByLabel(labelnameorlocator,false, 1,value);

        if (element != null && !element.isSelected()) {
            element.click();
            logger.info("RadioButton Selected with locator '{}'", labelnameorlocator);
        }
    }



    private WebElement getRadioButtonByLabel(String labelNameOrLocator, boolean isLocator, int index, String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String xPathLocator;
        try {

            if (isLocator) {
                // If labelNameOrLocator is already an XPath
                xPathLocator = String.format("(%s)[%d]", labelNameOrLocator, index);
            } else {
                // Dynamically set XPath based on Yes or No value using the provided structure and index

                // Index used to select a specific instance if there are multiple labels with the same name
                xPathLocator = String.format("(//div[./div[normalize-space(text())='%s']]//div[@role='radio' and @aria-label='%s'])[%d]", labelNameOrLocator,value , index);
                System.out.println(xPathLocator);
            }
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception e) {
            e.printStackTrace();  // Optional: Print the exception stack trace for debugging.
            return null;

            
        }
    }
    public void selectRadioButtonByAriaLabel(String ariaLabelValue) {
        WebElement element = getRadioButtonByAriaLabel(ariaLabelValue);

        if (element != null && !element.isSelected()) {
            element.click();
            logger.info("RadioButton with aria-label '{}' selected.", ariaLabelValue);
        } else if (element != null) {
            logger.info("RadioButton with aria-label '{}' is already selected.", ariaLabelValue);
        } else {
            logger.error("RadioButton with aria-label '{}' not found.", ariaLabelValue);
        }
    }

    // Reusable method to get any radio button element by its aria-label attribute
    private WebElement getRadioButtonByAriaLabel(String ariaLabelValue) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String xPathLocator;
        try {
            // XPath to select radio button using aria-label value
            xPathLocator = String.format("//div[@role='radio' and @aria-label='%s']", ariaLabelValue);
            System.out.println(xPathLocator);

            // Wait until the radio button is clickable and return it
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception e) {
            logger.error("Exception while trying to get RadioButton with aria-label '{}'", ariaLabelValue, e);
            return null;
        }
    }

}
