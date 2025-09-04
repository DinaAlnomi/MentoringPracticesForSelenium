package assignments.Week02Day04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TaskOne {
    static WebDriver driver;

    //Task 1: Browser History Exploration
//Setup:
    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Test is running");

    }

    @AfterEach
    void tearDown() {
        driver.quit();
        System.out.println("Test finished");
    }

    @Test
    public void test1() {

        driver.navigate().to("https://www.wikipedia.org");
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().contains("Wikipedia"));
        driver.navigate().to("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"));


        driver.navigate().back();
        assertTrue(driver.getTitle().contains("Wikipedia"));
        assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().forward();
        assertTrue(driver.getTitle().contains("Wikipedia"));
        assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().back();
        assertTrue(driver.getTitle().contains("Wikipedia"));
        assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().forward();
        assertTrue(driver.getTitle().contains("Wikipedia"));
        assertTrue(driver.getTitle().contains("Google"));


    }
}













