package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    WebDriver oDriver;
    LoginPage(WebDriver oBrowser){
        PageFactory.initElements(oBrowser, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement obj_UserName_Edit;

    @FindBy(xpath = "//input[@name='pwd']")
    private WebElement obj_Password_Edit;

    @FindBy(xpath = "//a[@id='loginButton']")
    private WebElement obj_Login_Button;

    @FindBy(id = "headerContainer")
    private WebElement obj_Login_Header;

    @FindBy(css = "img[src*='timer.png']")
    private WebElement obj_Login_Logo_image;

    @FindBy(xpath = "//td[@class='pagetitle']")
    private WebElement obj_Homepage_Header;

    @FindBy(xpath = "//a[@id='logoutLink']")
    private WebElement obj_Logout_Link;


    public boolean verifyLoginLogoExist(){
        Assert.assertTrue(obj_Login_Logo_image.isDisplayed(), "Failed to locate the Login Logo image");
        return true;
    }


    public boolean verifyLoginHeaderExist(){
        Assert.assertTrue(obj_Login_Header.isDisplayed(), "Failed to locate the Login header");
        Assert.assertEquals(obj_Login_Header.getText(), "Please identify yourself", "Invalid login header text is displayed");
        return true;
    }


    public boolean loginToActiTime(String userName, String password) {
        try {
            obj_UserName_Edit.sendKeys(userName);
            obj_Password_Edit.sendKeys(password);
            obj_Login_Button.click();
            Thread.sleep(2000);
            Assert.assertEquals(obj_Homepage_Header.getText(), "Enter Time-Track", "Failed to login to ActiTime");
            return true;
        }catch (InterruptedException e) {
            System.out.println("Exception in 'loginToActiTime()' method. "+e);
            return false;
        }
    }


    public boolean logoutFromApplication(){
        try{
            obj_Logout_Link.click();
            Thread.sleep(2000);
            Assert.assertTrue(obj_Login_Logo_image.isDisplayed(), "Failed to Logout from the application");
            return true;
        }catch (Exception e) {
            System.out.println("Exception in 'logoutFromApplication()' method. "+e);
            return false;
        }
    }


}
