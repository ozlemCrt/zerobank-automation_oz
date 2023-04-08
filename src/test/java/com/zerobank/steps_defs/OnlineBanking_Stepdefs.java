package com.zerobank.steps_defs;

import com.zerobank.pages.MainPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;

public class OnlineBanking_Stepdefs {
    MainPage mainPage=new MainPage();
    OnlineBankingPage onlineBankingPage=new OnlineBankingPage();


    @And("The user go to {string} page")
    public void theUserGoToPage(String pageName) {
        Driver.get().navigate().back();
        mainPage.moreServicesButton.click();
        onlineBankingPage.navigateToPage(pageName);
    }
}
