package assignments.Week4.day1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Task02RobotClassForKeyActions extends BaseClass {

/*
Go to https://claruswaysda.github.io/downloadUpload.html
Click on 'Upload'
Close the opening page using 'CTRL+F4'
*/


    @Test
    void task02RobotClassForKeyActions() throws AWTException {
        Robot robot = new Robot();

        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        WebElement button = driver.findElement(By.xpath("//label[@class='upload-btn']"));
        actions.click(button).perform();

        //condition to know system mac or windows
        if (System.getProperty("os.name").toLowerCase().contains("win")) {

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_F4);
            System.out.println("os is windows");
        }
        else if (System.getProperty("os.name").toLowerCase().contains("mac")) {

            robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
            robot.keyPress(java.awt.event.KeyEvent.VK_W);
            robot.keyRelease(java.awt.event.KeyEvent.VK_W);
            robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);

            System.out.println("os is mac");
        }





    }
}
