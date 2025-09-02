package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01NavigateBackAndForward {


    public static void main(String[] args) throws InterruptedException {
        /* TC - 01





// Refresh the Browser using refresh command. 


       */
        // Invoke Chrome Browser 
        WebDriver driver = new ChromeDriver();
        // Invoke Chrome Browser 
        driver.navigate().to("https://www.w3schools.com/");

        // Navigate to URL: https://stackoverflow.com/ 
        driver.get("https://stackoverflow.com/ "); //just to try

        // Come back to the w3schools using the back command. 
        driver.navigate().back();
         //Thread.sleep(1000);

        // Again go back to the stackoverflow website using forward command 
        driver.navigate().forward();
        //Thread.sleep(1000);

        // Refresh the Browser using refresh command. 
        driver.navigate().refresh();
        //Thread.sleep(1000);









        // Close the Browser.
        driver.quit(); //close the whole session
        driver.quit(); // close the tab




    }




}
