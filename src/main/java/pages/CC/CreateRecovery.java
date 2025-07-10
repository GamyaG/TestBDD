package pages.CC;

import pages.BasePage;

public class CreateRecovery extends BasePage {
    public CreateRecovery()
    {
        pageElementsSetup();
    }
    public void waitForCreateRecoveryScreen()
    {
        label.waitForScreenHeading("Create Recovery");
    }
    public void selectPayer()
    {
        dropDown.selectDropDown("Payer","Enigma Fire & Casualty");
    }
    public void selectReserveLine()
    {
        dropDown.selectDropDownByIndex("Reserve Line",1);
    }
    public void selectRecoveryCategory()
    {
        dropDown.selectDropDown("Recovery Category","Credit to loss");
    }
    public void enterAmount()
    {
        inputField.setInputField("Amount","100");
    }
    public void clickUpdate()
    {
        buttons.clickButton("Update");
    }
    public void waitForTransactionScreen()
    {
        label.waitForScreenHeading("Financials: Transactions");
    }
    public void verifyRecoveryLoaded()
    {
        ccElements.verifyRecoveries();
    }


}
