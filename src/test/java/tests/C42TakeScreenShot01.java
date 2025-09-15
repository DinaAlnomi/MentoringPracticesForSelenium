package tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C42TakeScreenShot01 extends BaseClass{


    @Test
    public void screenShotTest() throws IOException, InterruptedException {
        //       Go to Clarusway
        driver.get("https://opensource-demo.orangehrmlive.com/");
         Thread.sleep(3000);


        //Take full page screenshot
        TakesScreenshot ss = (TakesScreenshot) driver;
        File screenShot = ss.getScreenshotAs(OutputType.FILE);

        Path path = Path.of(System.getProperty("user.dir"), "screenshot", "lastScreenshot.png");
        FileUtils.copyFile(screenShot, path.toFile());
    }
}






