package assignments.Week4.day2;

import assignments.BaseClass;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Task03UserRegisterationAndScreenshotCapture extends BaseClass {

/*
Go to https://claruswaysda.github.io/homepage.html
Register a user
Sign in with the registered user
Take all pages' screenshots
Take 'Celebrate Login' button's screenshot.
Capture a screenshot of the page with confetti.
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
    void task03UserRegisterationAndScreenshotCapture() throws InterruptedException, IOException {
        driver.get("https://claruswaysda.github.io/homepage.html");
        WebElement userIcon = driver.findElement(By.xpath("//*[@id=\"userIcon\"]/i"));
        WebElement registerButton = driver.findElement(By.partialLinkText("Register"));
        Thread.sleep(2000);

        //Take full page screenshot
        TakesScreenshot ss = (TakesScreenshot) driver;
        File screenShot = ss.getScreenshotAs(OutputType.FILE);

        Path path = Path.of(System.getProperty("user.dir"), "screenshot", "lastScreenshot1.png");
        FileUtils.copyFile(screenShot, path.toFile());

        actions.moveToElement(userIcon).click().perform();
        actions.click(registerButton).perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);


        Path path2 = Path.of(System.getProperty("user.dir"), "screenshot", "lastScreenshot2.png");
        FileUtils.copyFile(screenShot, path2.toFile());

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

        Path path3 = Path.of(System.getProperty("user.dir"), "screenshot", "lastScreenshot3.png");
        FileUtils.copyFile(screenShot, path3.toFile());





    }
}