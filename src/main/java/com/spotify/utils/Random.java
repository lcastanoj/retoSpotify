package com.spotify.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Random {
    public static WebElement selectRandom(List<WebElement> items) {
        java.util.Random random = new java.util.Random();
        int index = random.nextInt(items.size());
        return items.get(index);
    }
}
