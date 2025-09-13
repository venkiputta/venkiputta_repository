package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validationlable {
    public static void main(String[] args) {
        labelValidations();
    }
    public static void labelValidations(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/yaduv/AppData/Local/Temp/Rar$EXa12032.23494/SG_01st-SEPT-2025_HTML%20Pages_Locators/HTML/Webpage/SampleWebPage.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//h1[text()='Header One']")).isDisplayed()){
                System.out.println("The Header exist");
            }else{
                System.out.println("Failed to find the header");
            }

            if(oBrowser.findElements(By.xpath("//h1[text()='Header One']")).size() > 0){
                System.out.println("The Header exist");
            }else{
                System.out.println("Failed to find the header");
            }


            //2. Read
            System.out.println("*****************Read the text from the header*****************");
            String strText = oBrowser.findElement(By.xpath("//p[contains(text(), 'One')]")).getText();
            if(strText.equals("Sample paragraphs One")) System.out.println("The paragraph value is correct");
            else System.out.println("Invalid paragraph content");


            //3. Height & width
            System.out.println("*****************get the Height and Width of the given element*****************");
            WebElement oEle = oBrowser.findElement(By.xpath("//h1[text()='Header One']"));
            System.out.println("Height: " + oEle.getSize().getHeight());
            System.out.println("Width: " + oEle.getSize().getWidth());

            //4. css properties
            System.out.println("*****************get the css attributes of the given element*****************");
            oEle = oBrowser.findElement(By.xpath("//h1[text()='Header One']"));
            System.out.println(oEle.getCssValue("color"));
            System.out.println(oEle.getCssValue("font-size"));
            System.out.println(oEle.getCssValue("font-family"));


            //5. enabled/disabled
            System.out.println("*****************Verify element is enabled/not*****************");
            oEle = oBrowser.findElement(By.xpath("//h1[text()='Header One']"));
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
