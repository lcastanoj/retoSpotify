package com.spotify.stepsDefinitions;

import com.spotify.steps.HomeStep;
import com.spotify.steps.LoginStep;
import com.spotify.steps.LoginValidation;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {
    @Steps
    LoginValidation loginValidation;

    @Steps
    HomeStep homeSteps;

    @Steps
    LoginStep loginStep;

    @Given("the user is on the Spotify page")
    public void theUserIsOnTheSpotifyPage() {
        homeSteps.openBrowser();
    }

    @When("the user clicks the login button and enters credentials")
    public void theUserClicksTheLoginButtonAndEntersCredentials() {
        homeSteps.theUserClosesTheCookiesWindow();
        homeSteps.theUserClicksTheLoginButton();
        loginStep.theUserEntersTheCredentials();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        loginValidation.assertion();
    }
}
