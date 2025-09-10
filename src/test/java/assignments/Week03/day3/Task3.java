package assignments.Week03.day3;
import assignments.BaseClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



    public class Task3 extends BaseClass {

        @Test
        void task1()  {

           //Open https://demoqa.com/select-menu
            driver.navigate().to("https://demoqa.com/select-menu");

            // Select Standard Multi-Select using element id
            WebElement multiSelectElement = driver.findElement(By.id("cars"));

           //Verify element is multi-select
            Select selector = new Select(multiSelectElement);
            Assertions.assertTrue(selector.isMultiple(),"this Element is NOT multi-select");
            System.out.println("the element is multi-select");

           //Select 'Opel' using index, then deselect using index
            selector.selectByIndex(2);
            //deselect
            selector.deselectByIndex(2);

           //Select 'Saab' using value, then deselect using value
            selector.selectByValue("saab");
            //deselect
            selector.deselectByValue("saab");

           //Deselect all options
            selector.deselectAll();


        }



    }

