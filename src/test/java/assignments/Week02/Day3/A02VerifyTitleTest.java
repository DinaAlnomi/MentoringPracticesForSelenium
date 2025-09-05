package assignments.Week02.Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    public static class A04DriverManageWindowCommandsChrome {


        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();

            // Open URL https://www.google.com
            driver.navigate().to("https://www.google.com");

            //Maximize the window
            driver.manage().window().maximize();
            //Wait 5 seconds
            Thread.sleep(5000);

            //Print the position + dimensions of the page in maximized state
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            System.out.println("height = " + height);
            System.out.println("width = " + width);

            //Make the page fullscreen
            driver.manage().window().fullscreen();

            //close the browser
            driver.quit();






        }
    }
}
