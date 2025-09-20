package assignments.Week4.day3;

import assignments.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import utilities.Excelhelper;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class T03StudentGradingSystem extends BaseClass {



    Workbook workbook;
    @Test
    void writeExcelTest() throws IOException {

        Workbook workbook = new Excelhelper("src/test/resources/StudentScores.xlsx").getWorkbook();
        Sheet sheet = workbook.getSheet("Sheet1");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            double score = sheet.getRow(i).getCell(1).getNumericCellValue();
            //System.out.println("score = " + score);
            String grade = "";
            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else if (score >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            sheet.getRow(i).createCell(2).setCellValue(grade);
        }

        FileOutputStream fo = new FileOutputStream("src/test/resources/StudentScores.xlsx");
        workbook.write(fo);

        //Then: Assert that the grade of "Alice" is "A"
        String aliceGrade = "";
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0).getStringCellValue().equals("Alice")) {
                aliceGrade = sheet.getRow(i).getCell(2).getStringCellValue();
            }
        }

        assertEquals("A", aliceGrade);

        workbook.close();
        fo.close();
    }





    }












