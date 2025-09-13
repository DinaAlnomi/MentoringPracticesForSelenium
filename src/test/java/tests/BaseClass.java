package tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); }

    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

}
