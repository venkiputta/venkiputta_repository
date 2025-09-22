package scripting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testscriptcase {
    public static void main(String[] args) {
        ts_Automation();

    }
    public static void ts_Automation(){
        WebDriver oBrowser = null;
        try{
            //Open browser
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();

            //Load the URL
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            //Login to the application
            oBrowser.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
            oBrowser.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
            oBrowser.findElement(By.xpath("//a[@id='loginButton']")).click();
            Thread.sleep(2000);

            //VErify login is successful
            if(oBrowser.findElement(By.xpath("//input[@id='SubmitTTButton']")).isDisplayed()){
                System.out.println("Login to ActiTime is successful");

                if(oBrowser.findElements(By.xpath("//div[@style='display: block;']")).size() > 0){
                    oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
                }
            }else{
                System.out.println("Failed to login to actiTime");
                return;
            }

            //create user
            oBrowser.findElement(By.xpath("//div[text()='USERS']")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//input[@name='firstName']")).sendKeys("test");
            oBrowser.findElement(By.xpath("//input[@name='lastName']")).sendKeys("user1");
            oBrowser.findElement(By.xpath("//input[@name='email']")).sendKeys("test.user1@sg.com");
            oBrowser.findElement(By.xpath("//input[@name='username']")).sendKeys("testuser1");
            oBrowser.findElement(By.xpath("//input[@name='password']")).sendKeys("Mercury");
            oBrowser.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("Mercury");

            oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
            Thread.sleep(2000);

            //VErify user is created successful
            if(oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='user1, test']")).isDisplayed()){
                System.out.println("The new user is created successfule");
            }else{
                System.out.println("Failed to create the new user");
                return;
            }


            //delete the newly created user
            oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='user1, test']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//button[contains(text(), 'Delete User')]")).click();
            Thread.sleep(2000);
            oBrowser.switchTo().alert().accept();
            Thread.sleep(2000);


            //VErify user is deleted
            if(oBrowser.findElements(By.xpath("//div[@class='name']/span[text()='user1, test']")).size() > 0){
                System.out.println("Failed to delete the user");
                return;
            }else{
                System.out.println("User is delted successful");
            }


            //logout from the application
            oBrowser.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);

            //VErify logout is successful
            if(oBrowser.findElement(By.id("headerContainer")).getText().equals("Please identify yourself")){
                System.out.println("Logout from the actiTime is successful");
            }else{
                System.out.println("Failed to logout form the actiTime");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
