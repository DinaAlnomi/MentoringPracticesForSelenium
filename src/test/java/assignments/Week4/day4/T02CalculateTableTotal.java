package assignments.Week4.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;

import java.util.List;

public class T02CalculateTableTotal extends TestBase2 {


    @Test
    void calculateTableTotal() {
        // Go to the site
        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("claruswaysda web site is opened ....");

        // Get prices

        List<WebElement> priceList = driver.findElements(By.xpath("//table[2]//td[3]"));

        int total = 0;
        for (WebElement priceElement : priceList) {
            String priceText = priceElement.getText().replace("$", ""); // remove $
            int price = Integer.parseInt(priceText);
            total += price;
        }

        System.out.println("Total price = " + total);
        logger.info("Total price = " + total);

        // Expected total: 1000 + 150 + 20 + 800 + 200 + 5 + 100 = 2275
        Assertions.assertEquals(2275, total);
    }
}





