package com.spotify.pageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SearchSongPage extends PageObject {
    private final By btnSearch = By.xpath("//a[@aria-label='Search']");
    public By getBtnSearch() {
        return btnSearch;
    }

    private final By inputSearch = By.xpath("//input[@data-encore-id='text']");
    public By getInputSearch(){
        return inputSearch;
    }

    private final By btnPlaySong = By.xpath("//div/div/div/div/button[contains(@aria-label, 'Play Diamonds')]");
    public By getBtnPlaySong(){
        return btnPlaySong;
    }
}
