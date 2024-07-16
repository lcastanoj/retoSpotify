package com.spotify.steps;

import com.spotify.pageObjects.HomePage;
import com.spotify.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LoginValidation {
    @Page
    HomePage homePage;

    @Step
    public void assertion() {
        ArrayList<Map<String, String>> data = Excel.extractTo();
        assertEquals(data.get(0).get("validate1"), homePage.getLblWelcome().getText());
    }
}
