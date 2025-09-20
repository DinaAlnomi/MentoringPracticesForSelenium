package assignments.Week4.day4;

import assignments.BaseClass;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class T03ExportTabelToExcel extends BaseClass {

    /*
Go to https://claruswaysda.github.io/webTable.html
Write the entire Table 1 to a new Excel sheet.
*/
    @Test
    void exportTableToExcel() throws IOException {
        // Go to the page
        driver.get("https://claruswaysda.github.io/webTable.html");

        // Locate Table 1
        WebElement table = driver.findElement(By.xpath("//table[1]"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Create a workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Table1");

              // Loop over table rows
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);

            // Capture both headers <th> and data <td>
            List<WebElement> cells = rows.get(i).findElements(By.xpath("./th|./td"));

            for (int j = 0; j < cells.size(); j++) {
                excelRow.createCell(j).setCellValue(cells.get(j).getText());
            }
        }

        // Save workbook to file
        try (FileOutputStream fos = new FileOutputStream("src/test/resources/Grades.xlsx")) {
            workbook.write(fos);
        }
        workbook.close();

        System.out.println("Table 1 exported to Grades.xlsx");
    }
}









