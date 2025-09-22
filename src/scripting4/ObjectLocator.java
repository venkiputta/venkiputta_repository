package scripting4;

import org.openqa.selenium.By;

public interface ObjectLocator {
    public static By obj_UserName_Edit = By.xpath("//input[@id='username']");
    public static By obj_Password_Edit = By.xpath("//input[@name='pwd']");
    public static By obj_Login_Button = By.xpath("//a[@id='loginButton']");
    public static By obj_SaveChange_Button = By.xpath("//input[@id='SubmitTTButton']");
    public static By obj_ShortCut_Dialog = By.xpath("//div[@style='display: block;']");
    public static By getObj_ShortCut_Close_Button = By.id("gettingStartedShortcutsMenuCloseId");
    public static By obj_USERS_Menu = By.xpath("//div[text()='USERS']");
    public static By obj_AddUser_Button = By.xpath("//div[text()='Add User']");
    public static By obj_User_FirstName_Edit = By.xpath("//input[@name='firstName']");
    public static By obj_User_LastName_Edit = By.xpath("//input[@name='lastName']");
    public static By obj_User_Email_Edit = By.xpath("//input[@name='email']");
    public static By obj_User_UserName_Edit = By.xpath("//input[@name='username']");
    public static By obj_User_Password_Edit = By.xpath("//input[@name='password']");
    public static By obj_User_retypePassword_Edit = By.xpath("//input[@name='passwordCopy']");
    public static By obj_CreateUser_Button = By.xpath("//span[text()='Create User']");
    public static String obj_UserName_Link = "//div[@class='name']/span[text()='%s']";
    public static By obj_Logout_Link = By.xpath("//a[@id='logoutLink']");
    public static By obj_LoginPage_Header = By.id("headerContainer");
}
