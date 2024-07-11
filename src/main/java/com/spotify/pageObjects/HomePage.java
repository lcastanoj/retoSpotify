package com.spotify.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObject {
    private final By btnLogin = By.xpath("//button[@data-testid='login-button']");
    public By getBtnLogin() {
        return btnLogin;
    }

    @FindBy(xpath = "//a[@title='Liked Songs']")
    private WebElement lblWelcome;
    public WebElement getLblWelcome() {
        return lblWelcome;
    }
}
