package pom1;

import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.UtilityMethods;

import java.util.logging.Logger;

public class TestscriptLogin {
    private static final Logger log = LoggerFactory.getLogger(pom.TestscriptLogin.class);

    @Test
    public static void TS_LoginLogout(){
        WebDriver oBrowser = null;
        LoginPage login = null;
        try{
            oBrowser = UtilityMethods.launchBrowser("Chrome");
            UtilityMethods.navigateURL(oBrowser, "http://localhost/login.do");
            login = new LoginPage(oBrowser);
            Assert.assertTrue(login.verifyLoginLogoExist(), "Exception in 'verifyLoginLogoExist()' method");
            Assert.assertTrue(login.verifyLoginHeaderExist());
            Assert.assertTrue(login.loginToActiTime("admin", "manager"));
            Assert.assertTrue(login.logoutFromApplication());
        }catch(Exception e){
            System.out.println("Exception in 'TS_LoginLogout()' test Script. "+e);
        }finally {
            oBrowser.close();
            oBrowser = null;
            login = null;
        }
    }


}
