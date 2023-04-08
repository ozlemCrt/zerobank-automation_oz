package com.zerobank.steps_defs;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivity_Stepdefs {
    AccountActivityPage accountActivityPage=new AccountActivityPage();
    @Then("The user should see the default tab {string} in the account menu")
    public void theUserShouldSeeTheDefaultTabInTheAccountMenu(String expectedTab) {
        accountActivityPage.verifySelect(expectedTab);
    }

    @Then("The user should see tabs in the account menu")
    public void theUserShouldSeeTabsInTheAccountMenu(List<String>expectedTabs) {
accountActivityPage.verifyTabs(expectedTabs);
    }

    @Then("The user should see columns in the table")
    public void theUserShouldSeeColumnsInTheTable(List<String> expectedColumnNames) {
        System.out.println(BrowserUtils.getElementsText(accountActivityPage.transactionsColumnsNames));

        Assert.assertEquals(expectedColumnNames, BrowserUtils.getElementsText(accountActivityPage.transactionsColumnsNames));


    }
}
