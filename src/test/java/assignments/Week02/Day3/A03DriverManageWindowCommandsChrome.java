package assignments.Week02.Day3;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A03DriverManageWindowCommandsChrome {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        // Go to Amazon URL
        driver.navigate().to("https://www.amazon.com");

        // Print the position and size of the page.
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        System.out.println("height = " + height);
        System.out.println("width = " + width);

        int x = driver.manage().window().getPosition().x;
        int y = driver.manage().window().getPosition().y;
        System.out.println("x = " + x);
        System.out.println("y = " + y);


        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(100, 100));
        driver.manage().window().setSize(new Dimension(900, 700));

        // Test that the page


        //Close the page
        driver.quit();







    }



}
