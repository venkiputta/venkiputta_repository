package automationscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcasefirst {
    public static void main(String[] args) {
        testScriptOne();

    }
    public static void testScriptOne(){
        WebDriver oBrowser = null;
        try{
            //1. Open browser
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            //2. navigate the actiTime URL
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);
            //3. Enter valid username and password
            oBrowser.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
            oBrowser.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
            //4. click on "Login" button
            oBrowser.findElement(By.xpath("//a[@id='loginButton']")).click();
            Thread.sleep(2000);
            //5. Verify login is successful
            if(oBrowser.findElement(By.xpath("//input[@id='SubmitTTButton']")).isDisplayed()){
                System.out.println("Login to actiTime is successful");
                if(oBrowser.findElements(By.xpath("//div[@style='display: block;']")).size() > 0){
                    oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
                }
            }else{
                System.out.println("Failed to login to actiTime");
                return;
            }
            //6. click on "Logout" link and verify logout is successful
            oBrowser.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);
            if(oBrowser.getCurrentUrl().equals("http://localhost/login.do")
                    && oBrowser.getTitle().equals("actiTIME - Login")
                    && oBrowser.findElement(By.xpath("//img[contains(@src, 'timer.png')]")).isDisplayed()){
                System.out.println("logout from actiTime is successful");
            }else{
                System.out.println("Failed to logout from actiTime");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            //7. close the browser
            oBrowser.close();
            oBrowser = null;
        }
    }

}
