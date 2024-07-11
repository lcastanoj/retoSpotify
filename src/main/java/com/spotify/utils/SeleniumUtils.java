package com.spotify.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class SeleniumUtils {
    public static void clickRandomElement(WebDriver driver, List<WebElement> elements) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null");
        }

        if (elements == null || elements.isEmpty()) {
            System.out.println("No elements found to click.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        WebElement randomElement = elements.get(randomIndex);

        Excel.writeToExcel("src/main/resources/data/search.xlsx", randomElement.getText(),1,4);

        Actions actions = new Actions(driver);
        actions.moveToElement(randomElement).click().perform();
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
