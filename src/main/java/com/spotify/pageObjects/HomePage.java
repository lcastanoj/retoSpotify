package com.spotify.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private final By btnMenu = By.id("preview-menu-button");
    public By getBtnMenu() {
        return btnMenu;
    }

    private final By btnMenuLogin = By.xpath("//button[@data-testid='preview-menu-login']");
    public By getBtnMenuLogin() {
        return btnMenuLogin;
    }

    private final By inputUsername = By.id("login-username");
    public By getInputUsername() {
        return inputUsername;
    }

    private final By inputPassword = By.id("login-password");
    public By getInputPassword() {
        return inputPassword;
    }

    private final By btnLogin = By.id("login-button");
    public By getBtnLogin() {
        return btnLogin;
    }
}
