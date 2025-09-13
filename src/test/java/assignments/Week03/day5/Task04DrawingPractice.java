package assignments.Week03.day5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseClass;

public class Task04DrawingPractice extends BaseClass {


    /*
Go to https://claruswaysda.github.io/Draw.html
Draw a triangle
Reset
*/

    @Test
    void drawingPractice() throws InterruptedException {
    driver.get("https://claruswaysda.github.io/Draw.html");
        WebElement myCanvas = driver.findElement(By.id("myCanvas"));
        actions.moveToElement(myCanvas, 50, 50).clickAndHold().moveByOffset(-50, -100).perform();
        actions.moveByOffset(-50, 100).perform();
        actions.moveByOffset(100, 0).release().perform();

        Thread.sleep(3000);
        WebElement resetButton = driver.findElement(By.id("resetButton"));
        actions.click(resetButton).perform();
        Thread.sleep(2000);




    }
}
