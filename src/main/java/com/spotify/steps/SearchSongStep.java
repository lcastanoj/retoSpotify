package com.spotify.steps;

import com.spotify.pageObjects.SearchSongPage;
import com.spotify.utils.Excel;
import com.spotify.utils.SeleniumUtils;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.spotify.utils.Excel.extractTo;

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
        SeleniumUtils.clickRandomElement(driver, playButtons);
        searchSongPage.getDriver().findElement(searchSongPage.getBtnPlaySong()).click();
        SeleniumUtils.waitForSeconds(2);
    }
}
