package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A02VerifyTitleTest {

    public static void main(String[] args) {

       //Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        //Go to https://www.youtube.com
        driver.navigate().to("https://www.youtube.com");

        //Verify the page title contains the word video
        String title = driver.getTitle();

        if (title.equals("video")) {

        System.out.println("Correct!"); }

        else {
        System.out.println("booo"); }

        driver.quit();


    }
}
