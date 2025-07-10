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

public class DatePicker extends BasePO {
    private final Logger logger = LoggerFactory.getLogger(DatePicker.class);
    public void selectDate(String labelname, String value, int index) {
        try {
            WebElement element = getDatePickerByLabel(labelname, index);

            if (element != null) {
                element.click();
            }

            String[] datelist = value.split("/");

            selectCalendarDate(datelist[2], datelist[1], datelist[0]);
        } catch (Exception ex) {
            logger.error("Unable to select date '{}' in calendar\n Error: {}", value, ex.getMessage());
        }
    }

    private void selectCalendarDate(String year, String month, String date) {
        String yearXPathLocator = "//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']";
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement yearElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(yearXPathLocator)));
        Select yearSelectElement = new Select(yearElement);
        yearSelectElement.selectByVisibleText(year);

        String monthXPathLocator = "//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']";
        WebElement monthElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(monthXPathLocator)));
        Select monthSelectElement = new Select(monthElement);
        monthSelectElement.selectByVisibleText(month);

        String dateXPathLocator = String.format("//table[@class='ui-datepicker-calendar']//td/span[text()='%s']", date);
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXPathLocator)));
        dateElement.click();
    }

    public boolean verifyLabelText(String labelname, String expectedText, int index) {
        WebElement element = getDatePickerByLabel(labelname, index);

        if (element != null && element.getText().equals(expectedText)) {
            logger.info("'{}' DatePicker value validation is successful", labelname);
            return true;
        } else {
            logger.info("'{}' DatePicker value validation is not successful", labelname);
            return false;
        }
    }

    public boolean verifyLabelExist(String labelname, int index) {
        WebElement element = getDatePickerByLabel(labelname, index);

        if (element != null) {
            logger.info("'{}' Date picker exists", labelname);
            return true;
        } else {
            logger.info("'{}' Date picker does not exist", labelname);
            return false;
        }
    }

    private WebElement getDatePickerByLabel(String labelname, int index) {
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        try {
            String xPathLocator = String.format("(//label[normalize-space(text())=\"%s\"]/..//input)[%d]/following-sibling::button", labelname, index);
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
        } catch (Exception ex) {
            logger.error("Error: Element locator '{}' did not match any elements.", labelname);
            throw new NotFoundException("Element not found", ex);
        }
    }
}

class NotFoundException extends RuntimeException {
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
