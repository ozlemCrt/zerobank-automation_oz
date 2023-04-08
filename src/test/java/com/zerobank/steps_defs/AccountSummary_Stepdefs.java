package com.zerobank.steps_defs;

import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummary_Stepdefs {
    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    @Then("The user should see page title {string}")
    public void theUserShouldSeePageTitle(String expectedTitle) {
        accountSummaryPage.verifyTitle(expectedTitle);

    }

    @Then("The user should see account type:")
    public void theUserShouldSeeAccountType(List<String> expectedTypes) {
        accountSummaryPage.verifyAccountTypes(expectedTypes);


    }

    @Then("The user should see columns in the {string} table")
    public void theUserShouldSeeColumnsInTheTable(String typeName,List<String>expextedAccountTypes) {
        accountSummaryPage.getModulText(typeName,expextedAccountTypes);
    }
}
