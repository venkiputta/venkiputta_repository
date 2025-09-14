package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Webtablevaliadtion {
    public static void main(String[] args) {
        webtableValidations();

    }
    public static void webtableValidations(){
        WebDriver oBrowser = null;
        Select oSelect = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/yaduv/AppData/Local/Temp/Rar$EXa27900.38026/SG_01st-SEPT-2025_HTML%20Pages_Locators/HTML/Webtables/SampleWebTables.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//table[@id='table1']")).isDisplayed()){
                System.out.println("The WebTable exist");
            }else{
                System.out.println("Failed to find the WebTable");
            }

            if(oBrowser.findElements(By.xpath("//table[@id='table1']")).size() > 0){
                System.out.println("The WebTable exist");
            }else{
                System.out.println("Failed to find the WebTable");
            }


            //2. How many webtables exist? read the second webtable attribute
            System.out.println("*****************How many webtables exist? read the second webtable attribute**********************");
            List<WebElement> oTables = oBrowser.findElements(By.xpath("//table"));
            System.out.println("No. of WebTables are: "+ oTables.size());
            System.out.println(oTables.get(1).getDomAttribute("id"));


            //3. Read the names of the male students from student table?
            System.out.println("*****************Read the names of the male students from student table?**********************");
            List<WebElement> oNames = oBrowser.findElements(By.xpath("//table[@id='table1']//td[text()='M']/preceding-sibling::td[3]"));
            for(int i=0; i<oNames.size(); i++){
                System.out.println(oNames.get(i).getText());
            }


            //4. Read the studentID of the female students from student table?
            System.out.println("*****************Read the studentID of the female students from student table?**********************");
            List<WebElement> oStdId = oBrowser.findElements(By.xpath("//table[@id='table1']//td[text()='F']/preceding-sibling::td[4]"));
            for(int i=0; i<oStdId.size(); i++){
                System.out.println(oStdId.get(i).getText());
            }


            //5. Select "Tamil NAdu" city for Abdul Kalam?
            System.out.println("*****************Select 'Tamil NAdu' city for Abdul Kalam?**********************");
            WebElement oEle = oBrowser.findElement(By.xpath("//table[@id='table2']//td[text()='Abdul Kalam']/following-sibling::td/select"));
            oSelect = new Select(oEle);
            oSelect.selectByVisibleText("Tamil Nadu");
            Thread.sleep(2000);


            //6. Select gender "male" for Narendra modi?
            System.out.println("*****************Select gender 'male' for Narendra modi?**********************");
            oEle = oBrowser.findElement(By.xpath("//table[@id='table2']//td[text()='Narendra Modi']/following-sibling::td[3]/input[1]"));
            oEle.click();
            Thread.sleep(2000);


            //7. Enter the salary 999999 for the person named "Rekha"
            System.out.println("*****************Enter the salary 999999 for the person named 'Rekha'?**********************");
            oEle = oBrowser.findElement(By.xpath("//table[@id='table2']//td[text()='Rekha']/following-sibling::td/input[@type='text']"));
            oEle.sendKeys("999999");
            Thread.sleep(2000);

            //8. Based on the city name given extract its description?
            System.out.println("*****************Based on the city name given extract its description?**********************");
            String cityName = "Raichur";
            List<WebElement> oItems = oBrowser.findElements(By.xpath("//table[@id='table3']//td[text()='"+cityName+"']/following-sibling::td/*/li"));
            for(int i=0; i<oItems.size(); i++){
                System.out.println(oItems.get(i).getText());
            }


            //9. Read the column names from the student table?
            System.out.println("*****************Read the column names from the student table?**********************");
            List<WebElement> oHeader = oBrowser.findElements(By.xpath("//table[@id='table1']//tr/th"));
            for(int i=0; i<oHeader.size(); i++){
                System.out.print(oHeader.get(i).getText()+"   ");
            }


            //10. Find the rows and columns of the 'Person Details' table?
            System.out.println("*****************Find the rows and columns of the 'Person Details' table?**********************");
            List<WebElement> oRows = oBrowser.findElements(By.xpath("//table[@id='table2']//tr"));
            System.out.println("No. of rows: "+ oRows.size());

            List<WebElement> oColumns = oBrowser.findElements(By.xpath("//table[@id='table2']//tr[1]/th"));
            System.out.println("No. of Columns: "+ oColumns.size());


            //11. select the gender Female for 'Smruthi Irani'?
            System.out.println("*****************select the gender Female for 'Smruthi Irani'?**********************");
            oEle = oBrowser.findElement(By.xpath("//table[@id='table2']//td[text()='Smruthi Irani']/following-sibling::td[3]/input[2]"));
            oEle.click();
            Thread.sleep(2000);


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
