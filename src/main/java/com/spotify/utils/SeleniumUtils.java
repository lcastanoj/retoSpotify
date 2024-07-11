package com.spotify.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class SeleniumUtils {
    public static void clickRandomElement(WebDriver driver, List<WebElement> elements) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver no puede ser null");
        }

        if (elements == null || elements.isEmpty()) {
            System.out.println("No se encontraron elementos para hacer clic.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        WebElement randomElement = elements.get(randomIndex);

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
