package assignments.Week4.day1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseClass;

import java.util.Set;

public class Task03CookieManagement extends BaseClass {

    /*
Go to https://claruswaysda.github.io/CookiesWait.html
Accept the alert if it is present
Print the cookies
Delete all cookies and assert
*/

    @Test
    void task03CookieManagement()  {

        driver.get("https://claruswaysda.github.io/CookiesWait.html");
        driver.switchTo().alert().accept();

        //conditional wait until id="acceptCookiesButton"

        wait.until(driver -> driver.findElement(By.id("acceptCookiesButton")).isDisplayed());
        driver.findElement(By.id("acceptCookiesButton")).click();

        //print all cookies
        Set cookies = driver.manage().getCookies();
        System.out.println("Cookies: " + cookies);

        //Delete all cookies and assert
        driver.manage().deleteAllCookies();
        Set cookiesAfterDeletion = driver.manage().getCookies();
        assert cookiesAfterDeletion.isEmpty() : "Cookies were not deleted successfully.";
        System.out.println("All cookies deleted successfully.");








    }

}
