package pages.CC;

import pages.BasePage;

import java.io.IOException;
import java.util.AbstractMap;

public class ServicesPage extends BasePage {
    public String servicesPage;
    public AbstractMap.SimpleEntry<String, String> servicePageExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;
    public ServicesPage()
    {
        pageElementsSetup();
        servicesPage="Service";
    }
    public void readTestDataForServicesPage() throws IOException {
        servicePageExistsLabelAndValue=commonFunctions.getLabelAndValue(servicesPage,"ServicesPage");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(servicesPage,"ClickNext");
    }
    public void waitForServicePage()
    {
        label.waitForScreenHeading("Step 4 of 5: Services");
    }
    public void clickNext()
    {
        buttons.clickButton("Next");
    }
}
