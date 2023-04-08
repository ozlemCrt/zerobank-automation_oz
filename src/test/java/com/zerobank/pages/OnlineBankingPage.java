package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;

public class OnlineBankingPage extends BasePage{
    public void navigateToPage(String pageName){
        Driver.get().findElement(By.xpath("//span[text()='"+pageName+"']")).click();
    }
}
