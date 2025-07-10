package pages.CC;

import pages.BasePage;
import utils.RandomGenerator;

public class AddNotes extends BasePage {
    public AddNotes()
    {
        pageElementsSetup();
    }
    public void clickNote()
    {
        ccElements.clickNotes();
    }
    public void waitForNotesScreen()
    {
        label.waitForScreenHeading("Notes");
    }
    public void clickNewNote()
    {
        buttons.clickButton("New Note");
    }
    public void selectTopic()
    {
        dropDown.selectDropDown("Topic","First notice of loss");
    }
    public void selectRelatedTo()
    {
        dropDown.selectDropDown("Related To","Claim");
    }
    public void enterText()
    {
        textArea.setTextAreaField("Text", RandomGenerator.firstName());
    }
    public void clickUpdate()
    {
        buttons.clickButton("Update");
    }
    public void verifyNoteAdded()
    {
        ccElements.verifyNoteAdded();
    }

}
