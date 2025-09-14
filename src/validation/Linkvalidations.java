package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class Linkvalidations {
    public static void main(String[] args) {
        linkValidations();

    }
    public static void linkValidations(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/yaduv/AppData/Local/Temp/Rar$EXa12032.23494/SG_01st-SEPT-2025_HTML%20Pages_Locators/HTML/Webpage/SampleWebPage.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//a[@id='link1_id']")).isDisplayed()){
                System.out.println("The Link exist");
            }else{
                System.out.println("Failed to find the Link");
            }

            if(oBrowser.findElements(By.xpath("//a[@id='link1_id']")).size() > 0){
                System.out.println("The Link exist");
            }else{
                System.out.println("Failed to find the Link");
            }


            //2. How many links exist? Read link names & Click on the third link?
            System.out.println("*****************How many links exist? Read link names & Click on the third link?**********************");
            List<WebElement> oLinks = oBrowser.findElements(By.xpath("//a"));
            System.out.println("No. of links: "+ oLinks.size());
            Iterator<WebElement> link = oLinks.iterator();
            while(link.hasNext()){
                System.out.println(link.next().getText());
            }
            oLinks.get(2).click();
            Thread.sleep(2000);
            System.out.println(oBrowser.getTitle());
            oBrowser.navigate().back();
            Thread.sleep(2000);


            //3. How to click the link?
            System.out.println("*****************How to click the link?**********************");
            oBrowser.findElement(By.xpath("//a[@id='link1_id']")).click();
            Thread.sleep(2000);
            String sParent = oBrowser.getWindowHandle();
            Object arr[] = oBrowser.getWindowHandles().toArray();
            oBrowser.switchTo().window(arr[1].toString());
            System.out.println(oBrowser.getTitle());
            oBrowser.close();
            oBrowser.switchTo().window(sParent);
            System.out.println(oBrowser.getTitle());


            //4. How to read the link attributes
            System.out.println("*****************How to read the link attributes**********************");
            System.out.println(oBrowser.findElement(By.xpath("//a[@id='link1_id']")).getDomAttribute("href"));


            //5. How many links opens in a new page?
            System.out.println("*****************How many links opens in a new page?**********************");
            oLinks = oBrowser.findElements(By.xpath("//a[@target]"));
            System.out.println("No. of links opens in a new page: "+ oLinks.size());
            for(WebElement oEle : oLinks){
                System.out.println(oEle.getText());
            }


            //6. How many links doesnot open in a new page (opens within the same page)
            System.out.println("*****************How many links doesnot open in a new page (opens within the same page)**********************");
            oLinks = oBrowser.findElements(By.xpath("//a[not(@target)]"));
            System.out.println("No. of links opens in the same page: "+ oLinks.size());
            for(WebElement oEle : oLinks){
                System.out.println(oEle.getText());
            }


            //7. How to read the link text?
            System.out.println("*****************How to read the link text?**********************");
            System.out.println(oBrowser.findElement(By.xpath("//a[@id='link2_id']")).getText());

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
