package org.naveen.pages;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Test
public class ExcelReading {

    public void readExcelFile() throws IOException {
        File excel=new File("C:\\Users\\navee\\OneDrive\\Desktop\\Sample Marks.xlsx");
        FileInputStream inputStream = new FileInputStream(excel);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        HSSFSheet sheet=wb.getSheet("Sheet 1");
        HSSFRow row = sheet.getRow(1);
        int rowCount = sheet.getLastRowNum();
        int cellCount = row.getLastCellNum();

        System.out.println(row.getCell(1).getStringCellValue());

    }

}
