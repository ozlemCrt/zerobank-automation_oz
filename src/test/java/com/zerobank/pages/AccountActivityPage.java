package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{
    @FindBy(css = "#aa_accountId")
    public WebElement accountSelect;
    Select select=new Select(accountSelect);
    @FindBy(xpath ="//tr//th")
    public List<WebElement>  transactionsColumnsNames;
    @FindBy(xpath = "//a[text()='Find Transactions']")
    private WebElement finfTransactionsButton;
    public void tabOnTransactions(){
        finfTransactionsButton.click();

    }

    public void verifySelect(String selectName){

      Assert.assertEquals(selectName,select.getFirstSelectedOption().getText());
    }
    public void verifyTabs(List<String> expectedTabs){
        List<WebElement> tabs=select.getOptions();
        Assert.assertEquals(expectedTabs, BrowserUtils.getElementsText(tabs));
    }

}
