package assignments.Week03.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseClass;

public class Task03DragAndDropPractice extends BaseClass {


    /*
    Go to https://claruswaysda.github.io/dragAndDrop.html
    Drag the items in their right places
    Assert the success message
*/

@Test
    void taskDragAndDrop()  {

    driver.get("https://claruswaysda.github.io/dragAndDrop.html");

    actions.dragAndDrop(driver.findElement(By.id("piece1")), driver.findElement(By.id("slot1"))).perform();
    actions.dragAndDrop(driver.findElement(By.id("piece2")), driver.findElement(By.id("slot2"))).perform();
    actions.dragAndDrop(driver.findElement(By.id("piece3")), driver.findElement(By.id("slot3"))).perform();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celebrate")));
    String message = driver.findElement(By.id("celebrate")).getText();
    Assertions.assertTrue(message.contains("Congratulations!"));

    }
}
