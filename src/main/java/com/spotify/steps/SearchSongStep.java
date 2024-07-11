package com.spotify.steps;

import com.spotify.pageObjects.SearchSongPage;
import com.spotify.utils.ExcelWriter;
import com.spotify.utils.RandomClick;
import com.spotify.utils.Waits;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static com.spotify.utils.CallData.extractTo;

public class SearchSongStep {
    @Page
    SearchSongPage searchSongPage;

    @Step("the user clicks the search button")
    public void theUserClicksTheSearchButton() {
        searchSongPage.getDriver().findElement(searchSongPage.getBtnSearch()).click();
    }

    @Step("the user enters the song to search")
    public void theUserEntersTheSongToSearch() {
        ArrayList<Map<String, String>> data = extractTo();
        searchSongPage.getDriver().findElement(searchSongPage.getInputSearch()).sendKeys(data.get(0).get("song"));
    }

    @Step("the user plays the song")
    public void theUserPlaysTheSong() {
        WebDriver driver = searchSongPage.getDriver();
        List<WebElement> playButtons = driver.findElements(searchSongPage.getBtnSelectSong());
        RandomClick.clickRandomElement(driver, playButtons);
        Waits.waitForSeconds(1);
        searchSongPage.getDriver().findElement(searchSongPage.getBtnPlaySong()).click();
        Waits.waitForSeconds(5);
    }
}
