package com.spotify.stepsDefinitions;

import com.spotify.steps.HomeSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {
    @Steps
    HomeSteps homeSteps;

    @Given("the user is on the Spotify page")
    public void theUserIsOnTheSpotifyPage() {
        homeSteps.openBrowser();
    }

    @When("the user clicks the login button and enters credentials")
    public void theUserClicksTheLoginButtonAndEntersCredentials() {
        homeSteps.theUserClicksTheLoginButton();
        homeSteps.theUserEntersTheCredentials();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
    }
}
