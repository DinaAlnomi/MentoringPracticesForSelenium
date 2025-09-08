package assignments.Week03.day1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01firstAssignment {

    // Navigate to: https://opensource-demo.orangehrmlive.com/
    // TODO: Test both approaches work
    static WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");


    }

    @AfterAll
    static void teardown() {
        driver.close();
    }

    @Test
    void relativeXpathTest() throws InterruptedException {
        Thread.sleep(5000);
        // Locate username using relative XPath
        WebElement relativeUsername = driver.findElement(By.xpath("//input[@name='username']"));
        System.out.println("Correct username field using relative XPath");

        // Locate password using relative XPath
        driver.findElement(By.xpath("//input[@name='password']"));
        System.out.println("Correct password field using relative XPath");

        // Locate login button using relative XPath
        driver.findElement(By.xpath("//button[@type='submit']"));
        System.out.println("Correct login button using relative XPath");
    }

    @Test
    void absoltuXpathTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        System.out.println("Correct username field using absolute XPath");

        // Locate password using absolute XPath
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        System.out.println("Correct password field using absolute XPath");

        // Locate login button using absolute XPath
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        System.out.println("Correct login button using absolute XPath");
    }
    }


