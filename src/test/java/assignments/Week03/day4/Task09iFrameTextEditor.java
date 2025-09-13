package assignments.Week03.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseClass;

import java.time.Duration;

public class Task09iFrameTextEditor extends BaseClass {

    @Test
    public void iFrameTextEditorTest() {
        //Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the bolded text contains "Editor"

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String boldedText = driver.findElement(By.tagName("h3")).getText();


        Assertions.assertTrue(boldedText.contains("Editor"), "Bolded text does not contain 'Editor'");

        //Locate the text box
        WebElement textBox = driver.findElement(By.xpath("//p[contains(text(), 'your content goes here')]"));
        //Delete the text in the text box
        textBox.clear();
        //Type "Hi everyone"
        textBox.sendKeys("Hi everyone");

        //Verify the text "Elemental Selenium" is displayed on the page
        WebElement elementalSeleniumLink = driver.findElement(By.linkText("Elemental Selenium"));
        Assertions.assertTrue(elementalSeleniumLink.isDisplayed(), "'Elemental Selenium' link is not displayed");
    }









   //
}
