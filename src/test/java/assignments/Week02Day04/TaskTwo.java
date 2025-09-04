package assignments.Week02Day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TaskTwo {

    static WebDriver driver;



    @BeforeEach
    void setUp() {

    driver = new ChromeDriver();
   driver.manage().window().maximize();

    }
    @AfterEach
    void tearDown()
    {
            driver.quit();
            System.out.println("Test finished");

    }

  @Test
    public void test1()  {
    driver.navigate().to("https://www.selenium.dev/");

    driver.getPageSource();
      assertTrue(driver.getPageSource().contains("WebDriver"));
      System.out.println("Pass");

    }

    @Test
    public void test2() {
        driver.navigate().to("https://www.python.org/");

        driver.getPageSource();
        assertTrue(driver.getPageSource().contains("Python"));
        System.out.println("Pass");





    }

}
