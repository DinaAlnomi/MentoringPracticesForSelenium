package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C03_NavigationTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testNavigation() {

        // :white_check_mark: Navigate to test pages
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // :white_check_mark: Click on "Locators - Find By Playground Test Page"
        driver.findElement(By.linkText("Locators - Find By Playground Test Page")).click();

        // :white_check_mark: Print current URL
        System.out.println("Current URL (Locators page): " + driver.getCurrentUrl());

        // :white_check_mark: Navigate back
        driver.navigate().back();

        // :white_check_mark: Print URL after going back
        System.out.println("URL after going back: " + driver.getCurrentUrl());

        // :white_check_mark: Click on "WebDriver Example Page"
        driver.findElement(By.linkText("WebDriver Example Page")).click();

        // :white_check_mark: Print current URL
        System.out.println("Current URL (WebDriver Example page): " + driver.getCurrentUrl());

        // :white_check_mark: Enter value 20 in number input
        WebElement numberInput = driver.findElement(By.id("numentry"));
        numberInput.clear();
        numberInput.sendKeys("20");

        // :white_check_mark: Click on the "submit" button to trigger the message
        driver.findElement(By.id("submit-to-server")).click();

        // :white_check_mark: Verify 'two, zero' message appears
        WebElement message = driver.findElement(By.id("message"));
        String actualMessage = message.getText();
        System.out.println("Message displayed: " + actualMessage);
        assertEquals("two, zero", actualMessage);
}
}
