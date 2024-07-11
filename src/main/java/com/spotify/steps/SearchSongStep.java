package com.spotify.steps;

import com.spotify.pageObjects.SearchSongPage;
import com.spotify.utils.MouseOver;
import com.spotify.utils.Waits;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.spotify.utils.CallData.extractTo;
import static com.spotify.utils.Random.selectRandom;

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
        Waits.waitForSeconds(5);

        List<WebElement> collections = searchSongPage.getDriver().findElements(searchSongPage.getBtnPlaySong());
        System.out.println(collections);

        WebElement elementToHover = searchSongPage.getDriver().findElement(searchSongPage.getBtnPlaySong());
        MouseOver.hoverOverElement(searchSongPage.getDriver(), elementToHover);
        
        WebElement element = selectRandom(collections);
        element.click();
    }
}
