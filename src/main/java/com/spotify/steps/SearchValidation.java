package com.spotify.steps;

import com.spotify.pageObjects.SearchSongPage;
import com.spotify.utils.Excel;
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
        ArrayList<Map<String, String>> data = Excel.extractTo();
        assertEquals(data.get(0).get("songSelect"), searchSongPage.getLblSong().getText());
    }
}
