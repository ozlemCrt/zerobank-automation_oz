package com.zerobank.steps_defs;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class AccountActivityNavigation_Stepdefs {
    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    @When("The user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String linkName) {
        accountSummaryPage.goToLink(linkName);


    }
}
