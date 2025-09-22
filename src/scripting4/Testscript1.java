package scripting4;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class Testscript1 extends ReusableMethods1 {
@DataProvider (name="testdata",parallel = true)
    public Object[][] data(){
        return new Object[][] {{"Chrome", "http://localhost/login.do", "admin", "manager"},
                {"Chrome", "http://localhost/login.do", "admin", "manager"},
                {"Chrome", "http://localhost/login.do", "admin", "manager"},
                {"Chrome", "http://localhost/login.do", "admin", "manager"},
                {"Chrome", "http://localhost/login.do", "admin", "manager"},
                {"Chrome", "http://localhost/login.do", "admin", "manager"},
                {"Chrome", "http://localhost/login.do", "admin", "manager"}};
    }
    @Test(dataProvider = "testdata")
    public static void TS_LoginLogoutParameter(String browser, String appURL, String userName, String password ){
        WebDriver oBrowser=null;
        try {
            oBrowser=launchBrowser(browser);
            boolean bln = navigateURL(oBrowser,appURL);
            bln=loginToApplication(oBrowser, userName, password);
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogoutParameter() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }





//
//
//   @Parameters(value = {"browser","appURL","userName","password"})  @DataProvider(name="testData")
//  @DataProvider(name="testData")
//  public Object[][] data(){
//      return new Object[][] {{"Chrome", "http://localhost/login.do", "admin", "manager"},
//              {"Edge", "http://localhost/login.do", "admin", "manager"},
//              {"FireFox", "http://localhost/login.do", "admin", "manager"}};
//  }
//    @Test(dataProvider = "testdata")
//   @Test
//    public static void TS_loginlogoutDataProvider(String browser, String appURL, String userName, String password) {
//        WebDriver oBrowser = null;
//
//        try {
//            oBrowser = launchBrowser(browser);
//            boolean blnRes = navigateURL(oBrowser, appURL);
//            blnRes = loginToApplication(oBrowser, userName, password);
//            blnRes = logoutFromActiTime(oBrowser);
//
//        } catch (Exception e) {
//            System.out.println("Exception in 'TS_loginlogoutDataProvider()' test script");
//
//        } finally {
//            oBrowser.close();
//            oBrowser = null;
//
//        }
//    }


//
//    @Test
//     public static void TS_loginlogout(){
//        WebDriver oBrowser=null;
//         Map<String,String> data=null;
//        try{
//            data=getExcelData("TestData", "TestData","TC_ID_001");
//            oBrowser=launchBrowser(data.get("browserName"));
//            boolean blnRes=navigateURL(oBrowser,data.get("url"));
//            blnRes=loginToApplication(oBrowser,data.get("userName"),data.get("password"));
//            blnRes=logoutFromActiTime(oBrowser);
//
//        } catch (Exception e) {
//            System.out.println("Exception in 'TS_loginlogout()' test script");
//
//        }finally {
//            oBrowser.close();
//            oBrowser=null;
//
//        }
//    }
//    public static void TS_CreateandDeleteUser(){
//        WebDriver oBrowser=null;
//        Map<String,String> data=null;
//        try{
//            data =getExcelData("TestData","TestData","TC_ID_002");
//            oBrowser=launchBrowser(data.get("browserName"));
//            boolean blnRes=navigateURL(oBrowser,data.get("url"));
//            blnRes=loginToApplication(oBrowser,data.get("userName"),data.get("password"));
//            String userName =createUser(oBrowser,data);
//            blnRes=deleteUser(oBrowser,userName);
//            //blnRes=logoutFromActiTime(oBrowser);
//
//        } catch (Exception e) {
//            System.out.println("Exception in 'TS_CreateandDeleteUser()' test script");
//
//        }finally {
//          //  oBrowser.close();
//            oBrowser=null;
//
//        }
//    }

}
