package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    public void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle,Driver.get().getTitle());
    }
}
