package validation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.util.List;

public class WebtabletoExcel {
    public static void main(String[] args) {
        webtableToExcel();

    }
    public static void webtableToExcel(){
        WebDriver oBrowser = null;
        Workbook wb = null;
        Sheet sh = null;
        Row row = null;
        Cell cell = null;
        List<WebElement> oRows = null;
        List<WebElement> oColumns = null;
        WebElement oEle = null;
        FileOutputStream fout = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/yaduv/AppData/Local/Temp/Rar$EXa27900.38026/SG_01st-SEPT-2025_HTML%20Pages_Locators/HTML/Webtables/SampleWebTables.html");
            Thread.sleep(2000);

            //Find the rows and columns form the webtable
            wb = new XSSFWorkbook();    //Creating new excel workbook
            sh = wb.createSheet("STUDENT");

            oRows = oBrowser.findElements(By.xpath("//table[@id='table1']//tr"));
            for(int r=0; r<oRows.size(); r++){
                row = sh.createRow(r);

                oColumns = oBrowser.findElements(By.xpath("//table[@id='table1']//tr["+(r+1)+"]/*"));
                for(int c=0; c< oColumns.size(); c++){
                    cell = row.createCell(c);
                    oEle = oBrowser.findElement(By.xpath("//table[@id='table1']//tr["+(r+1)+"]/*["+(c+1)+"]"));
                    cell.setCellValue(oEle.getText());
                }
            }

            fout = new FileOutputStream("E:\\MorningBatch_Online\\StudentDetails.xlsx");
            wb.write(fout);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                fout.flush();
                fout.close();
                fout = null;
                oBrowser.close();
                oBrowser = null;
                cell = null;
                row = null;
                sh = null;
                wb.close();
                wb = null;
            }catch(Exception e){}
        }
    }
}
