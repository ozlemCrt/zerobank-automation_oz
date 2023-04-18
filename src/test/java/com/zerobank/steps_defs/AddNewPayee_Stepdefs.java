package com.zerobank.steps_defs;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayee_Stepdefs {
    PayBillsPage payBillsPage=new PayBillsPage();
    AddNewPayeePage addNewPayeePage=new AddNewPayeePage();
    @Given("Creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> map) {
        BrowserUtils.sendKeys(addNewPayeePage.getPayeeName(),map.get("Payee Name"));
        BrowserUtils.sendKeys(addNewPayeePage.getPayeeAddres(),map.get("Payee Address"));
        BrowserUtils.sendKeys(addNewPayeePage.getAccount(),map.get("Account"));
        BrowserUtils.sendKeys(addNewPayeePage.getPayeeDetails(), map.get("Payee details"));

    }

    @When("Tabs on add button")
    public void tabs_on_add_button() {
        addNewPayeePage.getAddButton().click();

    }





    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        Assert.assertEquals(string, addNewPayeePage.getSuccesMessage().getText());


    }




}
