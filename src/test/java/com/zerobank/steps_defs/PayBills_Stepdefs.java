package com.zerobank.steps_defs;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class PayBills_Stepdefs {
    PayBillsPage payBillsPage=new PayBillsPage();


    @And("The user should enter the valid information for the payment process:{string},{string},{string},{string},{string}")
    public void theUserShouldEnterTheValidInformationForThePaymentProcess(String payee, String account, String amount, String date, String description) {
        payBillsPage.fillPayeBillsPage(payee,account,amount,date,description);
    }


    @Then("The user should see message text:{string}")
    public void theUserShouldSeeMessageText(String expectedMessage) {
        Assert.assertEquals(expectedMessage,payBillsPage.successMessage.getText());

    }

    @Then("The user verify that the message is visible {string}")
    public void theUserVerifyThatTheMessageIsVisible(String expectedMessage) {
        Assert.assertEquals(expectedMessage,payBillsPage.amountInputBox.getAttribute("validationMessage"));
    }



    @Then("The user verify that the message is not visible")
    public void theUserVerifyThatTheMessageIsNotVisible() {
        Assert.assertFalse(payBillsPage.successMessage.isDisplayed());
    }

    @Then("The user verify that the message is visible {string} in the date box")
    public void theUserVerifyThatTheMessageIsVisibleInTheDateBox(String expextedMessage) {
        Assert.assertEquals(expextedMessage,payBillsPage.dateInputBox.getAttribute("validationMessage"));

    }

    @Given("The user tabs on {string} pay bill subtitle")
    public void theUserTabsOnPayBillSubtitle(String subTitle) {
        payBillsPage.tabOnPayBillsSubTitle(subTitle);
    }
}
