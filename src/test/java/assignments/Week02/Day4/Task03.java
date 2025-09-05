package assignments.Week02.Day4;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task03 {
    static WebDriver driver;

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
    public void Test1() {

        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().setSize(new Dimension(800, 600));
}

@Test
    public void Test2() {
    driver.navigate().to("https://www.bbc.com/");
    driver.manage().window().setPosition(new Point(100, 100));


}







}
