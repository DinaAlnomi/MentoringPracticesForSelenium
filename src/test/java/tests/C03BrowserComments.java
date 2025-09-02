package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03BrowserComments {

    public static void main(String[] args) {

        // TC – 03
        // Launch Chrome browser 
        WebDriver driver = new ChromeDriver();

       // Expected Title 
        driver.navigate().to("https://www.linkedin.com");
        String title = driver.getTitle();
        System.out.println("Title = " + title);
        if (title.equals("linkedin")){
            System.out.println("test passed");
        }

   // Set Path of the Chrome driver 


// Open URL of Website 
// Maximize Window 
// Get Title of current Page 
// Validate/Compare Page Title 
// Close Browser









    }
}
