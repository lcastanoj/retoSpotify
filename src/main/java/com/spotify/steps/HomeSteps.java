package com.spotify.steps;

import com.spotify.pageObjects.HomePage;
import com.spotify.pageObjects.LoginPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.ArrayList;
import java.util.Map;

import static com.spotify.utils.CallData.extractTo;

public class HomeSteps {
    @Page
    HomePage homePage;

    @Step("User opens Spotify url")
    public void openBrowser() {
        homePage.openUrl("https://open.spotify.com/");
    }

    @Step("the user clicks the login button")
    public void theUserClicksTheLoginButton(){
        homePage.getDriver().findElement(homePage.getBtnLogin()).click();
    }

    @Step("the user closes the cookies window")
    public void theUserClosesTheCookiesWindow(){
        homePage.getDriver().findElement(homePage.getBtnCookies()).click();
    }
}
