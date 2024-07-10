package com.spotify.steps;

import com.spotify.pageObjects.HomePage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class HomeSteps {
    @Page
    HomePage homePage;

    @Step("User opens Spotify url")
    public void openBrowser() {
        homePage.openUrl("https://open.spotify.com/intl-es");
    }

    @Step("the user clicks the login button")
    public void theUserClicksTheLoginButton(){
        homePage.getDriver().findElement(homePage.getBtnMenu()).click();
        homePage.getDriver().findElement(homePage.getBtnMenuLogin()).click();
    }

    @Step("the user enters the credentials")
    public void theUserEntersTheCredentials(){
        homePage.getDriver().findElement(homePage.getInputUsername()).sendKeys("laucasj13");
        homePage.getDriver().findElement(homePage.getInputPassword()).sendKeys("Sali0313+");
        homePage.getDriver().findElement(homePage.getBtnLogin()).click();
    }
}
