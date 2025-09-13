package assignments.Week03.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.BaseClass;

import java.util.ArrayList;

public class Task01WindowHandlePractice extends BaseClass {

    /*
Go to https://claruswaysda.github.io/
Click on Window Handle
Click on 'Open Index Page'
Verify the link 'https://claruswaysda.github.io/index.html'
*/

    @Test
    void task1() {
        //Go to https://claruswaysda.github.io/
        driver.get("https://claruswaysda.github.io/");

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        String originalHandle = driver.getWindowHandle();

        //Click on Window Handle
        actions.click(driver.findElement(By.partialLinkText("Window Handle"))).perform();

        //there's a tab going to be opened after the click before, I want to swtch focus to it
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        //Click on 'Open Index Page'
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        actions.click(driver.findElement(By.partialLinkText("Open Index Page"))).perform();

        //switch to the new window

        for (String windowHandle : driver.getWindowHandles()) {
            // Find the handle that is not the original window's handle
            if (originalHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }

        //Verify the link 'https://claruswaysda.github.io/index.html'
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        String expectedUrl = "https://claruswaysda.github.io/index.html";

        Assertions.assertEquals(expectedUrl, currentUrl, "URL does not match the expected URL.");
            System.out.println("Test is finished");




    }
}}
