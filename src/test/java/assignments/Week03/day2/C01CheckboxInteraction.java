package assignments.Week03.day2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import java.util.List;

public class C01CheckboxInteraction {

        static WebDriver driver;

        @BeforeAll
        public static void setUp() {
            // Initialize WebDriver
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Navigate to the checkboxes page
            driver.get("https://the-internet.herokuapp.com/checkboxes");
        }

        @Test
        public void testCheckboxInteraction() {
            // Find all checkboxes on the page
            List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

            // Check the current state of both checkboxes and print to console
            System.out.println("First state of Checkbox 1: " + checkboxes.get(0).isSelected());
            System.out.println("First state of Checkbox 2: " + checkboxes.get(1).isSelected());

            // Ensure both checkboxes are selected (click only if not already selected)
            // Checkbox 1
            if (!checkboxes.get(0).isSelected()) {
                checkboxes.get(0).click();
                System.out.println("Checkbox 1 was clicked");
            }

            // Checkbox 2
            if (!checkboxes.get(1).isSelected()) {
                checkboxes.get(1).click();
                System.out.println("Checkbox 2 was clicked");
            }

            // Verify both checkboxes are checked after the operations
            Assertions.assertTrue(checkboxes.get(0).isSelected(), "Checkbox 1 should be selected.");
            Assertions.assertTrue(checkboxes.get(1).isSelected(), "Checkbox 2 should be selected.");
            System.out.println("both checkboxes are selected");

            // Print the final status of each checkbox
            System.out.println("Final state of Checkbox 1: " + checkboxes.get(0).isSelected());
            System.out.println("Final state of Checkbox 2: " + checkboxes.get(1).isSelected());
        }

        @AfterAll
        public static void tearDown() {
                driver.quit();

            }
        }

