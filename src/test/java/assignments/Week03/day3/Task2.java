package assignments.Week03.day3;
import assignments.BaseClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Task2 extends BaseClass {

        @Test
        void task2() {

          //Open https://demoqa.com/select-menu
            driver.get("https://demoqa.com/select-menu");

          // Select Old Style Select Menu using element id
            driver.findElement(By.id("oldSelectMenu"));
            Select theSelect = new Select(driver.findElement(By.id("oldSelectMenu")));

          //Print all dropdown options
            List<WebElement> allOptions = theSelect.getOptions();
            for (WebElement option : allOptions) {
                System.out.println(option.getText()); }

           //Select 'Purple' using index
            wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            theSelect.selectByIndex(4);
            System.out.println("Selected by Index =  " + theSelect.getFirstSelectedOption().getText());

           //Select 'Magenta' using visible text
            theSelect.selectByVisibleText("Magenta");
            System.out.println("Selected by Visible text = " + theSelect.getFirstSelectedOption().getText());

           // Select an option using value
            theSelect.selectByValue("3");
            System.out.println("Selected by Value = " + theSelect.getFirstSelectedOption().getText());

        }
    }

