package helper;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DropDownHelper extends GenericHelper {
    private static final Logger log = LoggerFactory.getLogger(DropDownHelper.class);
    public void SelectUsingVisibleValue(By locator, String visibleValue) {
        SelectUsingVisibleValue(getElement(locator), visibleValue);
    }
    public void SelectUsingVisibleValue(WebElement element, String visibleValue) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);
        log.info("Locator : " + element + " Value : " + visibleValue);
    }
    public void SelectUsingValue(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
        log.info("Locator : " + locator + " Value : " + value);
    }
    public void SelectUsingIndex(By locator, int index) {
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
        log.info("Locator : " + locator + " Index : " + index);
    }
    public void SelectUsingIndex(WebElement locator, int index) {
        Select select = new Select(locator);
        select.selectByIndex(index);
        log.info("Locator : " + locator + " Index : " + index);
    }
    public String getSelectedValue(By locator) {
        log.info(String.valueOf(locator));
        return getSelectedValue(getElement(locator));
    }
    public String getSelectedValue(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();
        log.info("WebELement : " + element + " Value : " + value);
        return value;
    }
    public List<String> getAllDropDownValues(By locator) {
        Select select = new Select(getElement(locator));
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();

        for (WebElement element : elementList) {
            log.info(element.getText());
            valueList.add(element.getText());
        }
        return valueList;
    }
}