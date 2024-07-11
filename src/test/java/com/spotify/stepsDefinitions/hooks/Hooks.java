package com.spotify.stepsDefinitions.hooks;

import com.spotify.steps.HomeStep;
import com.spotify.steps.LoginStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    @Managed
    WebDriver driver;

    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
    }

    @BeforeEach
    public void setUpTest() {
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void closeDriver() {
        WebDriverManager.chromedriver().quit();
    }

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
}
