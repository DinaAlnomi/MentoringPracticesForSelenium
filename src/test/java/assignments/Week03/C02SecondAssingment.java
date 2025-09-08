package assignments.Week03;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class C02SecondAssingment {
    // TODO: Navigate to test pages
    String url = "https://testpages.herokuapp.com/styled/index.html";



        static WebDriver driver;

        @BeforeAll
        public static void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        @Test
        void nav() throws InterruptedException {
            // TODO: Navigate to test pages
            driver.get(url);

            // TODO: Click on "Locators - Find By Playground Test Page"
            driver.findElement(By.partialLinkText("Find By Playground")).click();

            // TODO: Print current URL
            String currentURL = driver.getCurrentUrl();
            System.out.println("The current URL is = " + currentURL);
            Assertions.assertEquals("https://testpages.eviltester.com/styled/find-by-playground-test.html", currentURL);


            // TODO: Print URL after going back
            driver.navigate().back();
            String backURL = driver.getCurrentUrl();
            System.out.println("URL after going back = " + backURL);

            // TODO: Click on "WebDriver Example Page"
            driver.findElement(By.partialLinkText("WebDriver Example Page")).click();

            // TODO: Print current URL
            String ExPageURL = driver.getCurrentUrl();
            System.out.println("WebDriver Example Page URL = " + ExPageURL);

            // TODO: Enter value 20 in number input
            WebElement number = driver.findElement(By.xpath("//input[@name='number-entry']"));

            number.sendKeys("20");

            WebElement processButton = driver.findElement(By.id("submit-to-server"));
            processButton.click();
            //This step is extra to make sure it loads and won't fail
            Thread.sleep(6000);

            // TODO: Verify 'two, zero' message appears
            WebElement message = driver.findElement(By.id("message"));
            String messageValue = message.getText();

            System.out.println("message is = " + messageValue);
            Assertions.assertEquals("two, zero", messageValue, "'two, zero' message is displayed correctly");
        }

        @AfterAll
        public static void tearDown() throws InterruptedException {
            driver.quit();
        }


    }

