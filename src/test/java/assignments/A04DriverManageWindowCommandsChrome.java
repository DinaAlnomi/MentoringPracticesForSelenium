package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A04DriverManageWindowCommandsChrome {


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
