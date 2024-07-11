package com.spotify.stepsDefinitions;

import com.spotify.steps.LoginValidation;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {
    @Steps
    LoginValidation loginValidation;

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        loginValidation.assertion();
    }
}
