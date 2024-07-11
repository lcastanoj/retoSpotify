package com.spotify.steps;

import com.spotify.pageObjects.LoginPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.ArrayList;
import java.util.Map;

import static com.spotify.utils.Excel.extractTo;

public class LoginStep {
    @Page
    LoginPage loginPage;

    @Step("the user enters the credentials")
    public void theUserEntersTheCredentials() {
        ArrayList<Map<String, String>> data = extractTo();
        loginPage.getDriver().findElement(loginPage.getInputUsername()).sendKeys(data.get(0).get("username"));
        loginPage.getDriver().findElement(loginPage.getInputPassword()).sendKeys(data.get(0).get("password"));
        loginPage.getDriver().findElement(loginPage.getBtnSendLogin()).click();
    }
}
