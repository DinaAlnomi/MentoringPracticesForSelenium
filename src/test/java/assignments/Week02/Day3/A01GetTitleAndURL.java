package assignments.Week02.Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01GetTitleAndURL {

    //Create Main Method
    public static void main(String[] args) {

        //Create Chrome driver
        WebDriver driver = new ChromeDriver();

        //Open google home page:
        driver.navigate().to("https://www.google.com");

        //Get Title on page
        String title = driver.getTitle();
        System.out.println("title is: " + title);

        //Get Current URL on page
        String url = driver.getCurrentUrl();
        System.out.println("URL= " + url);

        //Close/quit the browser
        driver.quit();




    }
}
