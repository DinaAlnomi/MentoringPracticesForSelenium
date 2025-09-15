package assignments.Week4.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Task04RobotClass extends BaseClass {


    /*
     * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
     * Click into the username field.
     * Type the username using sendKeys.
     * Use the Robot class to:
     * Press Tab → go to password field.
     * Type the password using sendKeys.
     * Press Enter → submit the form.
     * Verify login success or error message.
     */

    @Test
    void robotClassTest() throws AWTException, InterruptedException {
        Robot robot = new Robot();

        driver.get("https://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        actions.click(username).sendKeys("tomsmith").perform();

        // Tab into password field
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(500);

        // Type the password
        String pass = "SuperSecretPassword!";
        for (char ch : pass.toCharArray()) {
            if (ch == '!') {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            } else {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(ch);
                if (keyCode == KeyEvent.VK_UNDEFINED) continue;

                boolean needsShift = Character.isUpperCase(ch);
                if (needsShift) robot.keyPress(KeyEvent.VK_SHIFT);

                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);

                if (needsShift) robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            robot.delay(50);
        }

        Thread.sleep(1000);



        // Click submit
        actions.click(driver.findElement(By.xpath("//button[@type='submit']"))).perform();
        Thread.sleep(3000);
        // Verify success message
        WebElement successMessage = driver.findElement(By.id("flash"));
        Assertions.assertTrue(successMessage.isDisplayed(), "Login success message is NOT displayed");

        Thread.sleep(3000);
    }


}
