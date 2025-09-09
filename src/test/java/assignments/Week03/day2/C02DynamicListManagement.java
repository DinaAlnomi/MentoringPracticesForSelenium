package assignments.Week03.day2;
import java.util.List;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;




import static org.junit.jupiter.api.Assertions.assertFalse;

    public class C02DynamicListManagement {
       static WebDriver driver;
        // I found this way on the internet for dynamic elements
        JavascriptExecutor js = (JavascriptExecutor) driver;

        @BeforeAll
        public static void setUp() throws InterruptedException {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
            Thread.sleep(3000);

        }

        @AfterAll
        public static void tearDown()  {
            driver.quit();
        }

        @Test
        public void DynamicListManagement() throws InterruptedException {

            Faker faker = new Faker();

            //Add 5 random tasks

            WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
            for (int i = 0; i < 5; i++) {
                String task = faker.job().title();
                inputBox.sendKeys(task);
                inputBox.sendKeys(Keys.ENTER);
                Thread.sleep(3000);
            }


            //  Mark every other task as completed

            List<WebElement> tasks = driver.findElements(By.cssSelector("ul li"));
            for (int i = 0; i < tasks.size(); i++) {
                if (i % 2 == 0) {

                    //strikethrough to be completed
                    tasks.get(i).click();
                }
            }


            //Delete all completed from DOM

            List<WebElement> completedTasks = driver.findElements(By.cssSelector("ul li.completed"));
            for (WebElement MyTask : completedTasks) {
                js.executeScript("arguments[0].remove();", MyTask);

             }


            //  remaining tasks should NOT be completed

            List<WebElement> remainingTasks = driver.findElements(By.cssSelector("ul li"));
            for (WebElement task : remainingTasks) {
                boolean TaskState = task.getAttribute("class").contains("completed");
                assertFalse(TaskState , "Task is not completed");
            }

        }
    }

