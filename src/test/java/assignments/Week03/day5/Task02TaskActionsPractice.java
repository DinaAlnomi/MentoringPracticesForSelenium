package assignments.Week03.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.BaseClass;

import java.util.ArrayList;

public class Task02TaskActionsPractice extends BaseClass {

    /*
Go to https://claruswaysda.github.io/submit-button.html
Click on submit
Verify link contains 'actionsClickDrag'
Drag 'Drag me' to 'Drop here'
Right-click on 'Right-click' me
Double-click on 'Double-click me'
Hover on 'Hover over me'
Verify all actions' success messages.
*/

    @Test
    void actionsPractice() {
         //Go to https://claruswaysda.github.io/submit-button.html
        driver.get("https://claruswaysda.github.io/submit-button.html");
        String homeURL = driver.getCurrentUrl();

        //Click on submit
        actions.click(driver.findElement(By.id("submitButton"))).perform();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));


        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

       // Verify link contains 'actionsClickDrag'
        String currentURL = driver.getCurrentUrl();
        Assertions.assertTrue(currentURL.contains("actionsClickDrag"));


        // Drag 'Drag me' to 'Drop here'
        actions.dragAndDrop(driver.findElement(By.id("drag1")), driver.findElement(By.id("drop1"))).perform();
        //right-click on 'Right-click' me
        actions.contextClick(driver.findElement(By.id("showSuccessButton"))).perform();

        //Double-click on 'Double-click me'
        actions.doubleClick(driver.findElement(By.id("doubleClickButton"))).perform();
        //Hover on 'Hover over me'
        actions.moveToElement(driver.findElement(By.id("hoverButton"))).perform();

       // Verify all actions' success messages
        Assertions.assertTrue(driver.findElement(By.id("dragSuccessMessage")).isDisplayed(),"Drag success message is NOT displayed");
        Assertions.assertTrue(driver.findElement(By.id("rightClickSuccessMessage")).isDisplayed(),"Right click success message is NOT displayed");
        Assertions.assertTrue(driver.findElement(By.id("doubleClickSuccessMessage")).isDisplayed(),"Double click success message is NOT displayed");
        Assertions.assertTrue(driver.findElement(By.id("hoverSuccessMessage")).isDisplayed(),"Hover success message is NOT displayed");


    }
}
