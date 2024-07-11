package com.spotify.steps;

import com.spotify.pageObjects.HomePage;
import com.spotify.pageObjects.SearchSongPage;
import com.spotify.utils.CallData;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SearchValidation {
    @Page
    SearchSongPage searchSongPage;

    @Step
    public void assertion() {
        ArrayList<Map<String, String>> data = CallData.extractTo();
        String expectedText = data.get(0).get("songSelect");

        String actualText = searchSongPage.getLblSong().getText();

        assertEquals(expectedText, actualText);

        System.out.println("Expected: " + expectedText);
        System.out.println("Actual: " + actualText);
    }
}
