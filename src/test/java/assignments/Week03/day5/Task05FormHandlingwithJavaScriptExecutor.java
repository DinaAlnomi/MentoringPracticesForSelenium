package assignments.Week03.day5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseClass;

public class Task05FormHandlingwithJavaScriptExecutor extends BaseClass {
/*
Go to https://claruswaysda.github.io/form.html
Create a method to flash the elements you are working on and use it.
Register a user
Login
Celebrate the login!
*/


    // Flash method
    public void flash(WebElement element, WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String originalColor = element.getCssValue("backgroundColor");

        for (int i = 0; i < 3; i++) {
            js.executeScript("arguments[0].style.backgroundColor='pink'", element);
            Thread.sleep(100);
            js.executeScript("arguments[0].style.backgroundColor='" + originalColor + "'", element);
            Thread.sleep(100);
        }
    }

    @Test
    void task05FormHandlingwithJavaScriptExecutor() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/form.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Fill the form
        WebElement ssn = driver.findElement(By.id("ssn"));
        flash(ssn, driver);
        js.executeScript("arguments[0].value='123-45-6789';", ssn);

        WebElement firstName = driver.findElement(By.id("first-name"));
        flash(firstName, driver);
        js.executeScript("arguments[0].value='Dina';", firstName);

        WebElement lastName = driver.findElement(By.id("last-name"));
        flash(lastName, driver);
        js.executeScript("arguments[0].value='3010 Clarusway';", lastName);

        WebElement address = driver.findElement(By.id("address"));
        flash(address, driver);
        js.executeScript("arguments[0].value='123 Main St, Riyadh';", address);

        WebElement phone = driver.findElement(By.id("phone"));
        flash(phone, driver);
        js.executeScript("arguments[0].value='0501234567';", phone);

        WebElement username = driver.findElement(By.id("username"));
        flash(username, driver);
        js.executeScript("arguments[0].value='clarusway-Dina';", username);

        WebElement email = driver.findElement(By.id("email"));
        flash(email, driver);
        js.executeScript("arguments[0].value='email@test.com';", email);

        WebElement password = driver.findElement(By.id("password"));
        flash(password, driver);
        js.executeScript("arguments[0].value='123456';", password);

        WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
        flash(confirmPassword, driver);
        js.executeScript("arguments[0].value='123456';", confirmPassword);

        // Click Register
        WebElement registerBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        flash(registerBtn, driver);
        js.executeScript("arguments[0].click();", registerBtn);

        Thread.sleep(1000);


        // celebrate with an alert
        js.executeScript("alert('Login Successful!');");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();




    }
}