package assignments.Week02.Day4;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {

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
    public void Test()
    {
        //Google
        driver.navigate().to("https://www.google.com/");
        String GoogleTitle = driver.getTitle();

        //Youtube
        driver.navigate().to("https://www.Youtube.com/");
        String YoutubeTitle = driver.getTitle();

        // Linkedin
        driver.navigate().to("https://www.linkedin.com/");
        String LinkedInTitle = driver.getTitle();

        Assertions.assertTrue(GoogleTitle.toLowerCase().contains("Google".toLowerCase()), "Google Title is not correct");
        System.out.println("Google is correct");

        Assertions.assertTrue(YoutubeTitle.toLowerCase().contains("YouTube".toLowerCase()), "YouTube Title is not correct");
        System.out.println("Youtube is correct");

        Assertions.assertTrue(LinkedInTitle.toLowerCase().contains("LinkedIn".toLowerCase()), "LinkedIN Title is not correct");
        System.out.println("LinkedIn is correct");

        //Navigate back twice
        driver.navigate().back();
        driver.navigate().back();

        //assert the URL of Google
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.google.com/", "Google URL is Not correct");
        System.out.println("Correct google URL");

        //Navigate forward twice and assert URL of LinkedIn
        driver.navigate().forward();
        driver.navigate().forward();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "linkedIn URL is not correct");
        System.out.println("Correct LinkedIn URL");




    }


}