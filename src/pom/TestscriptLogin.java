package pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestscriptLogin {
    @Test
    public static void TS_LoginLogout(){
        WebDriver oBrowser = null;
        LoginPage login = null;
        try{
            oBrowser = UtilityMethods.launchBrowser("Chrome");
            UtilityMethods.navigateURL(oBrowser, "http://localhost/login.do");
            login = new LoginPage(oBrowser);
            login.verifyLoginLogoExist();
            login.verifyLoginHeaderExist();
            login.loginToActiTime("admin", "manager");
            login.logoutFromApplication();
        }catch(Exception e){
            System.out.println("Exception in 'TS_LoginLogout()' test Script. "+e);
        }finally {
            oBrowser.close();
            oBrowser = null;
            login = null;
        }
    }

}
