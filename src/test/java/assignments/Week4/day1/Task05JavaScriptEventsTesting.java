package assignments.Week4.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseClass;

import java.util.List;

public class Task05JavaScriptEventsTesting extends BaseClass {


    /*
Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
Click all the buttons and verify they are all clicked
*/

    @Test
    void javaScriptEvents() {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String[] ids = {
                "onblur", "onclick", "oncontextmenu", "ondoubleclick", "onfocus",
                "onkeydown", "onkeyup", "onkeypress", "onmouseover", "onmouseleave", "onmousedown"
        };

        for (String id : ids) {
            WebElement btn = driver.findElement(By.id(id));

            // Scroll into view
            js.executeScript("arguments[0].scrollIntoView(true);", btn);

            switch (id) {
                case "onclick":
                    btn.click();
                    break;

                case "ondoubleclick":
                    actions.doubleClick(btn).perform();
                    break;

                case "oncontextmenu":
                    actions.contextClick(btn).perform();
                    break;

                case "onkeydown":
                    btn.click(); // focus first
                    actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
                    break;

                case "onkeyup":
                    btn.click();
                    actions.sendKeys(Keys.ENTER).perform();
                    break;

                case "onkeypress":
                    btn.click();
                    actions.sendKeys("A").perform();
                    break;

                case "onmouseover":
                    actions.moveToElement(btn).perform();
                    break;

                case "onmouseleave":
                    actions.moveToElement(btn).perform();
                    actions.moveByOffset(100, 100).perform(); // move away
                    break;

                case "onmousedown":
                    actions.clickAndHold(btn).release().perform();
                    break;

                case "onfocus":
                    btn.click(); // focus
                    break;

                case "onblur":
                    btn.click(); // focus
                    driver.findElement(By.id("onclick")).click(); // move focus away
                    break;
            }

            // Verify the status paragraph says "Event Triggered"
            WebElement status = driver.findElement(By.id(id + "status"));
            Assertions.assertTrue(status.getText().contains("Event Triggered"),
                    "Event " + id + " was not triggered.");
        }
    }


}
