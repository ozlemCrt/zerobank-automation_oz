package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(css = "#user_login")
    public WebElement loginInputBox;
    @FindBy(css = ".alert.alert-error")
    public WebElement warningMessage;
    public void login(String loginName,String password){
        Actions actions=new Actions(Driver.get());
        actions.click(loginInputBox).sendKeys(loginName+ Keys.TAB)
                .sendKeys(password+Keys.TAB+Keys.TAB+Keys.ENTER).perform();

    }
}
