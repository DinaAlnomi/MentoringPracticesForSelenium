package assignments.Week4.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import tests.BaseClass;

public class Task01javaScriptExecutorwithelementStyling extends BaseClass {

    /*
Go to https://claruswaysda.github.io/signIn.html
enter username 'admin'
enter password '123'
Click on Sign In
Assert the 'Employee Table' is visible
Create a method to change border color and style of web elements.
Use the method on each element you interact with.
*/


    @Test
    void task01javaScriptExecutorwithelementStyling() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/signIn.html");

        //enter username 'admin'
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('username').value='admin';");

        //enter password '123'
        js.executeScript("document.getElementById('password').value='123';");
        //Click on Sign In
        //Click on Sign In
        js.executeScript("document.querySelector('input[type=\"submit\"]').click();");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        //Assert the 'Employee Table' is visible
        WebElement employeeTable = (WebElement) js.executeScript("return document.getElementById('employeeTable');");
        Assertions.assertTrue(employeeTable.isDisplayed());


        //change style of table border
        changeStyle(employeeTable, "3px", "dashed", "red");



        Thread.sleep(5000);

    }

 //Use the method on each element you interact with.
        public void changeStyle(WebElement element, String width, String style, String color) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].style.border='" + width + " " + style + " " + color + "'",
                    element
            );

    }
}
