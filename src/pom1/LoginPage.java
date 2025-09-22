package pom1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver oDriver;
    LoginPage(WebDriver oBrowser){
        this.oDriver = oBrowser;
    }
    public By obj_UserName_Edit = By.xpath("//input[@id='username']");
    public By obj_Password_Edit = By.xpath("//input[@name='pwd']");
    public By obj_Login_Button = By.xpath("//a[@id='loginButton']");
    public By obj_Login_Header = By.id("headerContainer");
    public By obj_Login_Logo_image = By.xpath("//img[contains(@src, 'timer.png')]");
    public By obj_Homepage_Header = By.xpath("//td[@class='pagetitle']");
    public By obj_Logout_Link = By.xpath("//a[@id='logoutLink']");

    public boolean verifyLoginLogoExist(){
        if(oDriver.findElement(obj_Login_Logo_image).isDisplayed()){
            System.out.println("The Login Logo image exist");
            return true;
        }else{
            System.out.println("Failed to locate the Login Logo image");
            return false;
        }
    }


    public boolean verifyLoginHeaderExist(){
        boolean blnRes = false;
        if(oDriver.findElement(obj_Login_Header).isDisplayed()){
            String strText = oDriver.findElement(obj_Login_Header).getText();
            if(strText.equalsIgnoreCase("Please identify yourself")){
                System.out.println("The login header text is as expected");
                blnRes = true;
            }else{
                System.out.println("Invalid login header text is displayed");
                blnRes = false;
            }
            System.out.println("The Login Header text exist");
        }else{
            System.out.println("Failed to locate the Login header");
            blnRes = false;
        }
        return blnRes;
    }


    public boolean loginToActiTime(String userName, String password) {
        try {
            oDriver.findElement(obj_UserName_Edit).sendKeys(userName);
            oDriver.findElement(obj_Password_Edit).sendKeys(password);
            oDriver.findElement(obj_Login_Button).click();
            Thread.sleep(2000);
            if(oDriver.findElement(obj_Homepage_Header).getText().equalsIgnoreCase("Enter Time-Track")){
                System.out.println("Login to actiTime was successful");
                return true;
            }else{
                System.out.println("Failed to login to ActiTime");
                return false;
            }
        }catch (InterruptedException e) {
            System.out.println("Exception in 'loginToActiTime()' method. "+e);
            return false;
        }
    }


    public boolean logoutFromApplication(){
        try{
            oDriver.findElement(obj_Logout_Link).click();
            Thread.sleep(2000);
            if(oDriver.findElement(obj_Login_Logo_image).isDisplayed()){
                System.out.println("Logout from application was successful");
                return true;
            }else{
                System.out.println("Failed to Logout from the application");
                return false;
            }
        }catch (Exception e) {
            System.out.println("Exception in 'logoutFromApplication()' method. "+e);
            return false;
        }
    }

}
