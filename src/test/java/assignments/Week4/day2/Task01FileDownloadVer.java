package assignments.Week4.day2;

import assignments.BaseClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;

public class Task01FileDownloadVer extends BaseClass {

    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Click on download
Verify that 'QAProgram.png' file is downloaded
*/

    @Test
    void task01FileDownloadVer() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        // Click on download button
        driver.findElement(By.xpath("//a[@class='download-btn']")).click();

        // Verify that 'QAProgram.png' file is downloaded
        String home = System.getProperty("user.home");
        Path filePath = Path.of(home, "Downloads", "QAProgram.png");


        Thread.sleep(5000);
        Assertions.assertTrue(Files.exists(filePath), "File QAProgram.png was not downloaded successfully.");

    }
}
