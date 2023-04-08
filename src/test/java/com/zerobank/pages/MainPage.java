package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    @FindBy(css= "#signin_button")
    public WebElement signinButton;
    @FindBy(css = "#online-banking")
    public WebElement moreServicesButton;
}
