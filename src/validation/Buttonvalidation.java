package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buttonvalidation {
    public static void main(String[] args) {
        buttonValidations();
    }
    public static void buttonValidations(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/yaduv/AppData/Local/Temp/Rar$EXa12032.23494/SG_01st-SEPT-2025_HTML%20Pages_Locators/HTML/Webpage/SampleWebPage.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//input[@id='frm1_ok_id']")).isDisplayed()){
                System.out.println("The Button exist");
            }else{
                System.out.println("Failed to find the Button");
            }

            if(oBrowser.findElements(By.xpath("//input[@id='frm1_ok_id']")).size() > 0){
                System.out.println("The Button exist");
            }else{
                System.out.println("Failed to find the Button");
            }


            //2. Read the text from the button
            System.out.println("*****************Read the text from the Button*****************");
            String strText = oBrowser.findElement(By.xpath("//input[@id='frm1_ok_id']")).getDomAttribute("value");
            if(strText.equals("OK")) System.out.println("The Button value is correct");
            else System.out.println("Invalid Button content");

            //3. click the button
            System.out.println("*****************click the button*****************");
            oBrowser.findElement(By.xpath("//input[@id='frm1_ok_id']")).click();


            //4. move the cursor to the button
            Actions oAction = new Actions(oBrowser);
            oAction.moveToElement(oBrowser.findElement(By.xpath("//input[@id='frm1_ok_id']"))).perform();


            //5. Height & width
            System.out.println("*****************get the Height and Width of the given element*****************");
            WebElement oEle = oBrowser.findElement(By.xpath("//input[@id='frm1_ok_id']"));
            System.out.println("Height: " + oEle.getSize().getHeight());
            System.out.println("Width: " + oEle.getSize().getWidth());

            //6. css properties
            System.out.println("*****************get the css attributes of the given element*****************");
            oEle = oBrowser.findElement(By.xpath("//input[@id='frm1_ok_id']"));
            System.out.println(oEle.getCssValue("color"));
            System.out.println(oEle.getCssValue("font-size"));
            System.out.println(oEle.getCssValue("font-family"));


            //7. enabled/disabled
            System.out.println("*****************Verify element is enabled/not*****************");
            oEle = oBrowser.findElement(By.xpath("//input[@id='frm1_ok_id']"));
            if(oEle.isEnabled()) System.out.println("Element is enabled");
            else System.out.println("Element is disabled");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser.close();
            oBrowser = null;

        }
    }
}
