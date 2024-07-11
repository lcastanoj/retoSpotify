package com.spotify.stepsDefinitions;

import com.spotify.steps.SearchSongStep;
import com.spotify.steps.SearchValidation;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class SearchSongStepDefinitions {
    @Steps
    SearchSongStep searchSongStep;

    @Steps
    SearchValidation searchValidation;

    @When("the user searches for the desired song")
    public void theUserSearchesForTheDesiredSong() {
        searchSongStep.theUserClicksTheSearchButton();
        searchSongStep.theUserEntersTheSongToSearch();
    }

    @When("the user selects the song and plays it")
    public void theUserSelectsTheSongAndPlaysIt() {
        searchSongStep.theUserPlaysTheSong();
    }

    @Then("the selected song matches the searched song")
    public void theSelectedSongMatchesTheSearchedSong() {
        searchValidation.assertion();
    }
}
