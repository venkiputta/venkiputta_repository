package scripting3;

import org.openqa.selenium.WebDriver;
import scripting2.ReusableMethods;

import java.util.Map;

import static scripting3.ReusableMethods1.getPropData;

public class Testscript1 extends ReusableMethods1 {
    public static void main(String[] args) {
        //TS_loginlogout();
        TS_CreateandDeleteUser();


    }
     public static void TS_loginlogout(){
        WebDriver oBrowser=null;
         Map<String,String> data=null;
        try{
            data=getPropData("TestData");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean blnRes=navigateURL(oBrowser,data.get("url"));
            blnRes=loginToApplication(oBrowser,data.get("userName"),data.get("password"));
            blnRes=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_loginlogout()' test script");

        }finally {
            oBrowser.close();
            oBrowser=null;

        }
    }
    public static void TS_CreateandDeleteUser(){
        WebDriver oBrowser=null;
        Map<String,String> data=null;
        try{
            data =getPropData("TestData");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean blnRes=navigateURL(oBrowser,data.get("url"));
            blnRes=loginToApplication(oBrowser,data.get("userName"),data.get("password"));
            String userName =createUser(oBrowser,data);
            blnRes=deleteUser(oBrowser,userName);
            blnRes=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_CreateandDeleteUser()' test script");

        }finally {
            oBrowser.close();
            oBrowser=null;

        }
    }

}
