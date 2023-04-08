package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage{
   @FindBy(css="#sp_payee")
    public WebElement payeeSelect;
   @FindBy(css ="#sp_account")
    public WebElement accountSelect;
   @FindBy(css = "#sp_amount")
    public WebElement amountInputBox;
   @FindBy(css = "#sp_description")

    public WebElement descriptionInputBox;
   @FindBy(css="#sp_date")
   public WebElement dateInputBox;
   @FindBy(css = "#pay_saved_payees")
   public WebElement payButton;
   @FindBy(xpath ="//span[text()='The payment was successfully submitted.']")
   public WebElement successMessage;

   public void fillPayeBillsPage(String payee,String account, String amount,String date,String description){
       Select select=new Select(payeeSelect);
       select.selectByVisibleText(payee);
       Select select1=new Select(accountSelect);
       select1.selectByVisibleText(account);
       amountInputBox.sendKeys(amount);
       dateInputBox.sendKeys(date);
       descriptionInputBox.sendKeys(description);
       payButton.click();


   }
}
