package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeePage extends BasePage{
    @FindBy(css = "#np_new_payee_name")
    @CacheLookup
    private WebElement payeeName;
    @FindBy(css = "#np_new_payee_address")
    private WebElement payeeAddres;
    @FindBy(css = "#np_new_payee_account")
    private WebElement account;
    @FindBy(css = "#np_new_payee_details")
    private WebElement payeeDetails;
    @FindBy(css = "#add_new_payee")
    private WebElement addButton;
    @FindBy(css = "#alert_content")
    private  WebElement succesMessage;

    public WebElement getSuccesMessage() {
        return succesMessage;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getPayeeName() {
        return payeeName;
    }

    public WebElement getPayeeAddres() {
        return payeeAddres;
    }

    public WebElement getAccount() {
        return account;
    }

    public WebElement getPayeeDetails() {
        return payeeDetails;
    }
}
