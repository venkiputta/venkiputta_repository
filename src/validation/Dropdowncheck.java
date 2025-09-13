package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdowncheck {
    public static void main(String[] args) {
        dropdownValidations();

    }
    public static void dropdownValidations(){
        WebDriver oBrowser = null;
        Select oSelect = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/yaduv/AppData/Local/Temp/Rar$EXa12032.23494/SG_01st-SEPT-2025_HTML%20Pages_Locators/HTML/Webpage/SampleWebPage.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//select[@id='list1']")).isDisplayed()){
                System.out.println("The Dropdown exist");
            }else{
                System.out.println("Failed to find the Dropdown");
            }

            if(oBrowser.findElements(By.xpath("//select[@id='list1']")).size() > 0){
                System.out.println("The Dropdown exist");
            }else{
                System.out.println("Failed to find the Dropdown");
            }


            //6. What are the different ways we can select the dropdown values?
            //7. How to read the selected value from the dropdown?
            System.out.println("*****************What are the different ways we can select the dropdown values & read them?**********************");
            WebElement oEle = oBrowser.findElement(By.xpath("//select[@id='list1']"));
            oSelect = new Select(oEle);
            oSelect.selectByIndex(1);
            System.out.println(oSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);

            oSelect.selectByValue("hbl");
            System.out.println(oSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);

            oSelect.selectByVisibleText("Bangalore");
            System.out.println(oSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);


            //3. How many dropdowns present?
            System.out.println("*******************How many dropdowns present?**************");
            List<WebElement> oEles = oBrowser.findElements(By.xpath("//select[@id]"));
            System.out.println("No. of dropdowns are: " + oEles.size());


            //4. What are the values(options) present in the dropdown?
            System.out.println("*******************What are the values(options) present in the dropdown?**************");
            oEle = oBrowser.findElement(By.xpath("//select[@id='list1']"));
            oSelect = new Select(oEle);
            List<WebElement> oItems = oSelect.getOptions();
            for(int i=0; i<oItems.size(); i++){
                System.out.println(oItems.get(i).getText());
            }


            //5. Verify Given value is present in the dropdown?
            System.out.println("********************Verify Given value is present in the dropdown?*****************");
            oSelect = new Select(oBrowser.findElement(By.xpath("//select[@id='list1']")));
            String cityName = "Goa";
            oItems = oSelect.getOptions();
            int flag = 0;
            for(int i=0; i<oItems.size(); i++){
                if(oItems.get(i).getText().equalsIgnoreCase(cityName)){
                    flag++;
                    break;
                }
            }
            if(flag==0) System.out.println("The city '"+cityName+"' doesnot exist");
            else System.out.println("The city '"+cityName+"' exist");

            //8. How to select the multiple values from multi-select dropdown?
            System.out.println("************How to select the multiple values from multi-select dropdown?************");
            oSelect = new Select(oBrowser.findElement(By.xpath("//select[@id='list1'][@multiple]")));
            oSelect.selectByVisibleText("Raichur");
            oSelect.selectByVisibleText("Bangalore");
            oSelect.selectByVisibleText("Hubballi");
            Thread.sleep(2000);

            //9. How to read all the multiple value selected from multi-select dropdown?
            System.out.println("***********How to read all the multiple value selected from multi-select dropdown?**********");
            List<WebElement> allItems = oSelect.getAllSelectedOptions();
            for(int i=0; i<allItems.size(); i++){
                System.out.println(allItems.get(i).getText());
            }


            //10. How to unselect the multiselect values from multi-select dropdown?
            System.out.println("************How to unselect the multiselect values from multi-select dropdown?********");
            oSelect.deselectAll();
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
