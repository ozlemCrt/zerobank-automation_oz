package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignPage extends BasePage{
@FindBy(css = "#pc_currency")
    public WebElement currencySelect;
@FindBy(id="pc_calculate_costs")
public WebElement calculateButton;
public void verifyWarningMessage() {
    String expected="Please, ensure that you have filled all the required fields with valid values.";
    Alert alert = Driver.get().switchTo().alert();
    String text = alert.getText();
    Assert.assertEquals(expected,text);
}
public void verifySelect(List<String> expectedOptions){
    Select select=new Select(currencySelect);
    List<WebElement> options = select.getOptions();
    List<String> e = BrowserUtils.getElementsText(options);
    List<String> actualOptions=new ArrayList<>();
    for (int i = 1; i <e.size() ; i++) {
        String webElement = e.get(i);
        actualOptions.add(webElement);
    }
    Assert.assertEquals(expectedOptions,actualOptions);
    }




}

