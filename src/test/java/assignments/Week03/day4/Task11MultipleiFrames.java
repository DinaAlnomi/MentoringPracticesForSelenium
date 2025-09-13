package assignments.Week03.day4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseClass;

import java.time.Duration;

public class Task11MultipleiFrames extends BaseClass {
    /*
Go to URL: http://demo.guru99.com/test/guru99home/
1. Find the number of iframes on the page
2. Switch to the third iframe (JMeter Made Easy)
3. Click the link (https://www.guru99.com/live-selenium-project.html)
4. Exit the iframe and return to the main page */


    @Test
    void multipleIframes() {
       //Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");

        //1. Find the number of iframes on the page
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        int iframeCount = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iframes on the page: " + iframeCount);

        //Switch to the third iframe (JMeter Made Easy) - no it's the second iframe
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.switchTo().frame(1);

        //Click the link (https://www.guru99.com/live-selenium-project.html)
        driver.findElement(By.xpath("//a[contains(@href, 'live-selenium-project')]")).click();

        //Exit the iframe and return to the main page
        driver.switchTo().defaultContent();
    }
}
