package com.zerobank.steps_defs;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.ParseException;
import java.util.List;

public class FindTransactions_Stepdefs {
    FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
    AccountActivityPage accountActivityPage=new AccountActivityPage();
    @When("Tab on Find Transactions")
    public void tabOnFindTransactions() {
        accountActivityPage.tabOnTransactions();


    }

    @When("Send {string} keyword into description input box")
    public void sendKeywordIntoDescriptionInputBox(String s) {
        BrowserUtils.sendKeys(findTransactionsPage.getDescriptionInputBox(), s);

    }

    @When("Tap on find button")
    public void tapOnFindButton() {
        findTransactionsPage.tabOnFindButton();

    }

    @Then("Verify that all description results contains {string}")
    public void verifyThatAllDescriptionResultsContains(String str) {
        List<String>listOfTexts=findTransactionsPage.getAllTextsFromDescriptions();
      /*  boolean bool=true;
        for (String listOfText : listOfTexts) {
            if(!listOfText.contains(str)){
                bool=false;
                break;
            }

        }  Assert.assertTrue(bool);

       */
        boolean b = listOfTexts.stream().allMatch(n -> n.contains(str));//allMatch:hepsi içeriyor mu//anyMatch:sadece bir tanesi içeriyor mu
        Assert.assertTrue(b);





    }



    @When("The user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String date1, String date2) {
       findTransactionsPage.fillDate(date1,date2);


    }

    @Then("Verify that results table should only show transactions dates between {string} to {string}")
    public void verifyThatResultsTableShouldOnlyShowTransactionsDatesBetweenTo(String date1, String date2) throws ParseException {
        findTransactionsPage.verifyDatesOfRange(date1, date2);
       // findTransactionsPage.verifyDate(date2,date1);
    }

    @And("Verify that the results should be sorted by most recent date")
    public void verifyThatTheResultsShouldBeSortedByMostRecentDate() throws ParseException {
Assert.assertTrue(findTransactionsPage.isDatesSorted());

    }

    @Then("Verify that results table should show at least one result under Deposit")
    public void verifyThatResultsTableShouldShowAtLeastOneResultUnderDeposit() {
findTransactionsPage.verifyDepositUnder();
    }

    @Then("Verify that results table should show at least one result under Withdrawal")
    public void verifyThatResultsTableShouldShowAtLeastOneResultUnderWithdrawal() {
        findTransactionsPage.verifywithdrawalUnder();
    }

    @When("The user selects type {string} and clicks on Find")
    public void theUserSelectsTypeAndClicksOnFind(String name) {
        findTransactionsPage.setTypeSelect(name);
    }


    @But("Verify that results table should show no result under Withdrawal")
    public void verifyThatResultsTableShouldShowNoResultUnderWithdrawal() {
        findTransactionsPage.verifyWithdrawalempty();
    }

    @But("Verify that results table should show no result under Deposit")
    public void verifyThatResultsTableShouldShowNoResultUnderDeposit() {
        findTransactionsPage.verifyDepositempty();
    }
}
