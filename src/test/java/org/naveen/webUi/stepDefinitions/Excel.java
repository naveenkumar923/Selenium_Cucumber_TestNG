package org.naveen.webUi.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.ja.且つ;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Excel {


    public Excel(){

    }

    @Given("excel file is read")
    public void readFile() throws IOException {
//        String excel="C:/Users/navee/Documents/Sample Marks.xlsx";
        File excel=new File("C:/Users/navee/Documents/Sample Marks.xlsx");
        FileInputStream inputStream = new FileInputStream(excel);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=wb.getSheetAt(0);
        XSSFRow FirstRow = sheet.getRow(0);
//        XSSFCell cell=FirstRow.getCell(1);
        int rowCount=sheet.getLastRowNum();
        int colCount=FirstRow.getLastCellNum();
        

      for(Row r:sheet){
          for(Cell cell:r){
              switch (cell.getCellType()){
                  case STRING:
                      System.out.print(cell.getStringCellValue()+"\t");
                      break;

                  case NUMERIC:
                      System.out.print(cell.getNumericCellValue()+"\t");
                        break;

              }



          }
          System.out.println("");      }

      for(int i=1;i<=rowCount;i++){
          for(int j=1;j<=FirstRow.getLastCellNum();j++){
              sheet.getRow(i).getCell(3).setCellValue("Passed");
          }
      }
        FileOutputStream ops=new FileOutputStream("C:/Users/navee/Documents/Sample Marks.xlsx");
      wb.write(ops);

        wb.close();
        inputStream.close();

    }
}
