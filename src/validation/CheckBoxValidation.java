package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxValidation {
    public static void main(String[] args) {
        checkboxValidations();

    }
    public static void checkboxValidations(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/yaduv/AppData/Local/Temp/Rar$EXa12032.23494/SG_01st-SEPT-2025_HTML%20Pages_Locators/HTML/Webpage/SampleWebPage.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).isDisplayed()){
                System.out.println("The checkbox exist");
            }else{
                System.out.println("Failed to find the checkbox");
            }

            if(oBrowser.findElements(By.xpath("//input[@id='chk1_id']")).size() > 0){
                System.out.println("The Text Field exist");
            }else{
                System.out.println("Failed to find the Text Field");
            }


            //2. Select the checkbox/radio
            System.out.println("*****************Select the checkbox/radio**********************");
            oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).click();
            Thread.sleep(2000);

            //3. Verify checkbox/radio button is selected/not?
            System.out.println("*****************Verify checkbox/radio button is selected/not?**********************");
            if(oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).isSelected()){
                System.out.println("Checkbox is selected");
            }else{
                System.out.println("Failed to select the checkbox");
            }


            //4. unselect the checkbox/radio
            //5. Unselected/not
            System.out.println("****************unselect the checkbox/radio & Unselected/not**********************");
            oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).click();
            Thread.sleep(2000);
            if(oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).isSelected()){
                System.out.println("Failed to unselect the Checkbox");
            }else{
                System.out.println("The checkbox is unselected successful");
            }


            //6. How many checkboxes/radio? Select the second checkbox
            System.out.println("****************How many checkboxes/radio? Select the second checkbox**********************");
            List<WebElement> oEles = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
            System.out.println("No. of checkboxes are: "+ oEles.size());
            Thread.sleep(2000);
            oEles.get(1).click();
            if(oEles.get(1).isSelected()) System.out.println("Second checkbox is selected");
            else System.out.println("Failed to select the second checkbox");
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
