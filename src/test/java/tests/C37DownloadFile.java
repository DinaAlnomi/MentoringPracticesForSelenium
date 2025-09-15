package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C37DownloadFile extends BaseClass {
    /*
Go to URL: https://the-internet.herokuapp.com/download
    Download selenium-login_exeption.png
    Verify if the file downloaded successfully.
*/

    @Test
    public void FileDownLoadTest() throws InterruptedException, IOException {
        By seleniumSnapLinkText = By.linkText("random_data.txt");
        //Go to URL: https://the-internet.herokuapp.com/download

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(seleniumSnapLinkText).click();

        Thread.sleep(7000);
  String sep = System.getProperty("file.separator");

        String filepath = System.getProperty("user.home") + sep + "Downloads" + sep + "selenium-snapshot.png";
        Path path = Path.of(System.getProperty("user.home")+sep+"Downloads"+sep+"selenium-snapshot.png");
        System.out.println("path.toString() = " + path.toString());


        Assertions.assertTrue(Files.exists(Path.of(filepath)));
        //Download selenium-snapshot.png

        //Verify if the file downloaded successfully



       Files.deleteIfExists(Path.of(filepath));
    }
}