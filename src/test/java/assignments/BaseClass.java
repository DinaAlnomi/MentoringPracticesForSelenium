package assignments;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public JavascriptExecutor js;


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

}
