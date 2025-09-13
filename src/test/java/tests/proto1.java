package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class proto1 extends BaseClass {





    @Test
    void test1() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/");
        Thread.sleep(3000);
        String mainWindowHandle = driver.getWindowHandle();
        actions.click(driver.findElement(By.partialLinkText("Window Handle"))).perform();
        Thread.sleep(3000);
        actions.click(driver.findElement(By.partialLinkText("Open Index Page"))).perform();
        Thread.sleep(3000);
        Set<String> allWindowHandles = driver.getWindowHandles();

        driver.switchTo().window("newHandle");
        String currentURL =  driver.getCurrentUrl();
        System.out.println(currentURL);

    }
}
