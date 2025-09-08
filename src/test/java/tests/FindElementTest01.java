package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementTest01 {



    static WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterAll
    static void teardown() {
        driver.close();
    }

    @Test
    public void Test() throws InterruptedException {
        //Google
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(5000);
        driver.findElement(By.id("twotabsearchtextboxs")).sendKeys("Hi");
        Thread.sleep(5000);



    }

}
