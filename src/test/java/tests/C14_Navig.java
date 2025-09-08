package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C14_Navig {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Implicit wait is for the initial element search
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Explicit wait is for a specific condition to be met
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void nav() throws InterruptedException {
        // Navigate to test pages
        driver.get("https://testpages.eviltester.com/styled/index.html");

        // Click on "Locators - Find By Playground Test Page"
        driver.findElement(By.partialLinkText("Find By Playground")).click();

        // Print current URL
        String url1 =  driver.getCurrentUrl();
        System.out.println("current URL = " + url1);
        Assertions.assertEquals("https://testpages.eviltester.com/styled/find-by-playground-test.html", url1);

        // Navigate back
        driver.navigate().back();

        // Print URL after going back
        String url2 = driver.getCurrentUrl();
        System.out.println("URL after going back = " + url2);

        // Click on "WebDriver Example Page"
        driver.findElement(By.partialLinkText("WebDriver Example Page")).click();

        // Print current URL
        String url3 = driver.getCurrentUrl();
        System.out.println("current URL = " + url3);

        // Enter value 20 in number input and click the "Process On Server" button
        WebElement num = driver.findElement(By.xpath("//input[@name='number-entry']"));
        num.sendKeys("20");

        // Find the "Process On Server" button by its ID and click it
        WebElement processButton = driver.findElement(By.id("submit-to-server"));
        processButton.click();

        // Use explicit wait to ensure the message element is visible and has text
        // This line will wait for a new element with the ID "message" to appear on the page
        WebElement messageElement = driver.findElement(By.id("message"));
        String messageText = messageElement.getText();

        System.out.println("message text = " + messageText);
        Assertions.assertEquals("two, zero", messageText, "Verify 'two, zero' message is displayed");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        // Close driver
        Thread.sleep(3000);
        driver.quit();
    }
}