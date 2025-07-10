package stepDefinitions.CC;

import io.cucumber.java.en.*;
import pageobjects.NewBusinessCC;

public class AddNotes_Steps {
    NewBusinessCC newBusinessCC;
    public AddNotes_Steps(NewBusinessCC newBusinessCC)
    {
        this.newBusinessCC=newBusinessCC;
    }
    @And("User creates the note")
    public void user_creates_the_note() {
        newBusinessCC.createNote();

    }
    @Then("the note is added successfully to claim")
    public void the_note_is_added_successfully_to_claim() {
        newBusinessCC.verifyNoteLoaded();


    }

    @And("User searches with the claim number the claim summary details are loaded")
    public void userSearchesWithTheClaimNumberTheClaimSummaryDetailsAreLoaded() {
        newBusinessCC.searchForClaim();
        newBusinessCC.verifyClaimLoadedSuccessfully();
    }
}
