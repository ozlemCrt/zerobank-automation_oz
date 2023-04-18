package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{
    @FindBy(xpath = "//h2")
    public List<WebElement> accountTypes;
    @FindBy(xpath ="(//h2[text()='Credit Accounts']//following-sibling::div)[1]//th")
     public    List<WebElement>columNames;


    public void verifyAccountTypes(List<String> expextedAccountTypes){
        Assert.assertEquals(expextedAccountTypes,BrowserUtils.getElementsText(accountTypes));

    }
    public void getModulText( String tableName,List<String> expectedcolumn){
        Assert.assertEquals(expectedcolumn,BrowserUtils.getElementsText(By.xpath("(//h2[text()='"+tableName+"']//following-sibling::div)[1]//th")));

    }
    public void goToLink(String linkName){
        Driver.get().findElement(By.xpath("//a[text()='"+linkName+"']")).click();
    }

}
