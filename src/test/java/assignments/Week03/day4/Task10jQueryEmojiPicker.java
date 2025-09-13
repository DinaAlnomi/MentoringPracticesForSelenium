package assignments.Week03.day4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.BaseClass;

import java.time.Duration;

public class Task10jQueryEmojiPicker extends BaseClass {

    /*
Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
1. Maximize the website
2. Click on the second emoji
3. Click on all second emoji items
4. Return to the parent iframe
5. Fill out the form and press the apply button */
    @Test
    void testjQueryEmojiPicker() {
        //Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //Maximize the website
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //switch to iframe
        driver.switchTo().frame(driver.findElement(By.id("emoojis")));
        //Click on any emoji
        driver.findElement(By.xpath("//img[@class='emoji'][15]")).click();

       // Return to the parent iframe
        driver.switchTo().parentFrame();
        //Fill out the form and press the apply button
        driver.findElement(By.id("text")).sendKeys("Hello");
        driver.findElement(By.id("smiles")).sendKeys("Smile");

        //Fill out the form and press the apply button
        driver.findElement(By.id("send")).click();



    }
}
