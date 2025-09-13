package assignments.Week03.day5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import tests.BaseClass;

public class Task06DropdownHandling extends BaseClass {




    /*
Go to https://claruswaysda.github.io/Dropdowns.html
In 1. Traditional Dropdown select 'Ford'
In 2. Multi-Select Dropdown select 'Mercedes'
In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
*/



    @Test

        void dropdownsTest() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
            driver.get("https://claruswaysda.github.io/Dropdowns.html");
            driver.manage().window().maximize();

            // Traditional Dropdown
            WebElement traditionalDropdown = driver.findElement(By.id("carSelect"));
            Select selectClassic = new Select(traditionalDropdown);
            selectClassic.selectByVisibleText("Ford");

        // 2. Multi-Select Dropdown
        WebElement multiDropdown = driver.findElement(By.id("multiCarSelect"));
        Select selectMulti = new Select(multiDropdown);
        selectMulti.selectByVisibleText("Mercedes");
        Thread.sleep(1000);

        // 3. Custom Dropdown (Bootstrap-like)
        WebElement custom = driver.findElement(By.id("customDropdown"));
        js.executeScript("arguments[0].click();", custom);
        WebElement bmw = driver.findElement(By.xpath("//div[text()='BMW']"));
        js.executeScript("arguments[0].click();", bmw);
        Thread.sleep(1000);


        // 4. Static Auto-Suggest Dropdown
        WebElement staticSuggest = driver.findElement(By.id("staticInput"));
        actions.moveToElement(staticSuggest).click().sendKeys("Tesla Model 3").sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);

        //scroll down
        js.executeScript("window.scrollBy(0,250)", "");

        // 5. Dynamic Auto-Suggest Dropdown
        WebElement dynamic = driver.findElement(By.id("dynamicInput"));
        actions.moveToElement(dynamic).click().sendKeys("Toyota")
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();



    }

}
