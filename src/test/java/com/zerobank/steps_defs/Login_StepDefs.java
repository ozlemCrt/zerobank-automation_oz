package com.zerobank.steps_defs;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {
    MainPage mainPage=new MainPage();
    LoginPage loginPage=new LoginPage();
    @Given("The user go to the relevant site")
    public void theUserGoToTheRelevantSite() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user click signin button")
    public void theUserClickSigninButton() {
        mainPage.signinButton.click();

    }



    @And("The user logs in using {string} and {string}")
    public void theUserLogsInUsingAnd(String loginName, String password) {
        loginPage.login(loginName,password);
        //Driver.get().navigate().back();

    }

    @Then("The user should see message :{string}")
    public void theUserShouldSeeMessage(String expectedMessage) {

        Assert.assertEquals(expectedMessage,loginPage.warningMessage.getText().trim());
    }

    @And("The user taps on back button")
    public void theUserTapsOnBackButton() {
        Driver.get().navigate().back();

    }


    @Then("The user that {string} is visible on the board")
    public void theUserThatIsVisibleOnTheBoard(String expectedUserName) {
        Assert.assertEquals(loginPage.getUserNameTextOnLoginPage(),expectedUserName);
    }
}
