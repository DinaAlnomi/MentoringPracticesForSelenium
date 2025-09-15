package assignments.Week4.day2;

import assignments.BaseClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;

public class Task02FileUploadTesting extends BaseClass {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Upload a PDF using single upload button
Verify that 'Files uploaded successfully!'
Do negative test (No file or other than PDF)
Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
Test multiple PDFs as well
*/ @Test
    void task02MultipleFileUploadTogether() throws Exception {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        // Full paths of all files separated by newline
        Path pdf1Path = Path.of(System.getProperty("user.home"), "Downloads", "Random.pdf");
        Path pdf2Path = Path.of(System.getProperty("user.home"), "Downloads", "Random2.pdf");
        Path pdf3Path = Path.of(System.getProperty("user.home"), "Downloads", "Random3.pdf");

        String multiplePaths = pdf1Path.toString() + "\n" +
                pdf2Path.toString() + "\n" +
                pdf3Path.toString();

        // Click the visible upload button (NOT the hidden input)
        driver.findElement(By.cssSelector(".upload-btn")).click();

        // Robot to handle native dialog
        Robot robot = new Robot();
        robot.delay(2000);

        // Copy paths into clipboard
        StringSelection selection = new StringSelection(multiplePaths);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Paste with CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter to confirm
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        // Submit the form
        driver.findElement(By.xpath("//button[@class='submit-btn']")).click();

        // Assert success message
        String successMessage = driver.findElement(By.id("successBox")).getText();
        Assertions.assertTrue(successMessage.contains("Files uploaded successfully!"),
                "Upload success message not displayed");
    }

}
