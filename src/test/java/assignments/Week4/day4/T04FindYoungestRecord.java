package assignments.Week4.day4;

import assignments.BaseClass;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class T04FindYoungestRecord extends BaseClass {


    @Test
    void findYoungestRecord() {


         // Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        // Add 10 records using Faker
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("nameInput")).sendKeys(Faker.instance().name().fullName());
            driver.findElement(By.id("ageInput")).sendKeys(Faker.instance().number().numberBetween(18, 65) + "");
            new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(Faker.instance().number().numberBetween(1, 5));
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }

        //table rows
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        String[] allNames = new String[rows.size()];
        String[] allAges = new String[rows.size()];

         int youngestAge = 200;
         String youngestName = "";

        for (int i = 0; i < rows.size(); i++) {
            allNames[i] = rows.get(i).findElement(By.xpath(".//td[1]")).getText();
            allAges[i] = rows.get(i).findElement(By.xpath(".//td[2]")).getText();

            int age = Integer.parseInt(allAges[i]);

            if (age < youngestAge) {
                youngestAge = age;
                youngestName = allNames[i];
            }
        }

         // Print result
        System.out.println("Youngest is: " + youngestName + " (" + youngestAge + ")");



    }


}



