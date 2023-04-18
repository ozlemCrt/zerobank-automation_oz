package com.zerobank.steps_defs;

import com.zerobank.pages.PurchaseForeignPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class PurchaseForeign_Stepdefs {
    PurchaseForeignPage purchaseForeignPage=new PurchaseForeignPage();


    @Then("Verify that following currencies should be available")
    public void verifyThatFollowingCurrenciesShouldBeAvailable(List<String>expectedOptions) {

        purchaseForeignPage.verifySelect(expectedOptions);

    }

    @When("The user tries to calculate cost without selecting a currency")
    public void theUserTriesToCalculateCostWithoutSelectingACurrency() {
        purchaseForeignPage.calculateButton.click();
        
    }

    @Then("Verify that error message should be displayed")
    public void verifyThatErrorMessageShouldBeDisplayed() {
        purchaseForeignPage.verifyWarningMessage();
    }
}
