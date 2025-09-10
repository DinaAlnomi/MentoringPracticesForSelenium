package assignments.Week03.day3;
import assignments.BaseClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;



        public class Task1 extends BaseClass {

            @Test
            void verifyDropdownSelections() {
                //Navigate to the dropdown page
                driver.get("https://the-internet.herokuapp.com/dropdown");

                //Wait for the dropdown element to be present and create a Select object
                WebElement dropdownElement = driver.findElement(By.id("dropdown"));
                wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                Select dropdown = new Select(dropdownElement);

                //Select Option 1 using index and verify it
                dropdown.selectByIndex(1);
                Assertions.assertEquals("Option 1", dropdown.getFirstSelectedOption().getText(), "Failed to select Option 1 by index");

                //Select Option 2 by value and verify it
                dropdown.selectByValue("2");
                Assertions.assertEquals("Option 2", dropdown.getFirstSelectedOption().getText(), "Failed to select Option 2 by value");

                //Select Option 1 by visible text and verify it
                dropdown.selectByVisibleText("Option 1");
                Assertions.assertEquals("Option 1", dropdown.getFirstSelectedOption().getText(), "Failed to select Option 1 by visible text");

                //Print all dropdown values
                List<WebElement> options = dropdown.getOptions();
                System.out.println("All dropdown options:");
                options.forEach(option -> System.out.println(option.getText()));


                //Verify dropdown has "Option 2" text using a for loop with a boolean flag
                boolean found = false;
                for (WebElement option : options) {
                    if (option.getText().equals("Option 2")) {
                        found = true;
                        System.out.println("Option 2 is found and the condition is " + found);
                        break; // Exit the loop once the option is found
                    }
                }

                //Print the first selected option
                System.out.println("First selected option: " + dropdown.getFirstSelectedOption().getText());

                //Verify the dropdown size is 3
                Assertions.assertEquals(3, options.size(), "Dropdown size is not 3");
                System.out.println("dropdown size is = " + options.size());

            }
        }
