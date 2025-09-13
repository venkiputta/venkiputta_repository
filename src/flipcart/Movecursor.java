package flipcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Movecursor {
    public static void main(String[] args) {
        moveCursor_Flipkart();

    }
    public static void moveCursor_Flipkart(){
        WebDriver oBrowser = null;
        try {
            //1. Open browser
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();

            //2. navigate the actiTime URL
            oBrowser.navigate().to("https://www.flipkart.com/");
            Thread.sleep(4000);

            Actions oAction = new Actions(oBrowser);
            oAction.moveToElement(oBrowser.findElement(By.xpath("//span[text()='Fashion']/.."))).perform();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//a[text()='All']")).click();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            oBrowser.close();
            oBrowser=null;

        }
    }
}
