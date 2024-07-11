package com.spotify.pageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private final By inputUsername = By.id("login-username");
    public By getInputUsername() {
        return inputUsername;
    }

    private final By inputPassword = By.id("login-password");
    public By getInputPassword() {
        return inputPassword;
    }

    private final By btnSendLogin = By.id("login-button");
    public By getBtnSendLogin() {
        return btnSendLogin;
    }}
