package com.spotify.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchSongPage extends PageObject {
    private final By btnSearch = By.xpath("//a[@aria-label='Search']");
    public By getBtnSearch() {
        return btnSearch;
    }

    private final By inputSearch = By.xpath("//input[@data-encore-id='text']");
    public By getInputSearch(){
        return inputSearch;
    }

    private final By btnSelectSong = By.xpath("//*[@data-testid='search-tracks-result']//a/div[@data-encore-id='text']");
    public By getBtnSelectSong(){
        return btnSelectSong;
    }

    private final By btnPlaySong = By.xpath("//div[@data-testid='action-bar-row']//div/button");
    public By getBtnPlaySong(){
        return btnPlaySong;
    }

    @FindBy(xpath = "//span/h1")
    private WebElement lblSong;
    public WebElement getLblSong() {
        return lblSong;
    }
}
