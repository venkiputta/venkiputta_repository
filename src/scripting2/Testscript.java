package scripting2;

import org.openqa.selenium.WebDriver;

public class Testscript extends ReusableMethods {
    public static void main(String[] args) {
        TS_loginlogout();
        TS_CreateandDeleteUser();


    }
     public static void TS_loginlogout(){
        WebDriver oBrowser=null;
        try{
            oBrowser=launchBrowser("Edge");
            boolean blnRes=navigateURL(oBrowser,"http://localhost/login.do");
            blnRes=loginToApplication(oBrowser,"admin","manager");
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
        try{
            oBrowser=launchBrowser("chrome");
            boolean blnRes=navigateURL(oBrowser,"http://localhost/login.do");
            blnRes=loginToApplication(oBrowser,"admin","manager");
            String username=createUser(oBrowser);
            blnRes=deleteUser(oBrowser,username);
            blnRes=logoutFromActiTime(oBrowser);




        } catch (Exception e) {
            System.out.println("Exception in 'TS_CreateandDeleteUser()' test script");

        }finally {
            oBrowser.close();
            oBrowser=null;

        }
    }

}
