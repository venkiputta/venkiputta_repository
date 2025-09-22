package scripting3excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.*;

public class ReusableMethods1 {
    public static void main(String[] args) {

    }

    /************************************************************************
     * Method            : launchBrowser()
     * Purpose           : This method launches the required browsers viz., chrome, firefox and edge
     * Parameters        : String browserName
     * Return Type       : WebDriver
     * Author Name      : Test user1
     * Reviewed By      :
     * Reviewed Date    :
     * Modified by      :
     *************************************************************************/
    public static WebDriver launchBrowser(String browserName) {
        WebDriver oDriver = null;
        try {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    oDriver = new ChromeDriver();
                    break;
                case "firefox":
                    oDriver = new FirefoxDriver();
                    break;
                case "edge":
                    oDriver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Invalid browser name '" + browserName + "' was mentioned. Please provide the valid browser name");
                    return null;
            }

            if (oDriver != null) {
                oDriver.manage().window().maximize();
                System.out.println("The '" + browserName + "' browser was launched successful");
                return oDriver;
            } else {
                System.out.println("Failed to launch the '" + browserName + "' browser");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Exception in the 'launchBrowser()' method. " + e);
            return null;
        }
    }

    /************************************************************************
     * Method            : navigateURL()
     * Purpose           : This method loads the url
     * Parameters        : WebDriver oBrowser, String strURL
     * Return Type       : boolean
     * Author Name      : Test user
     *************************************************************************/
    public static boolean navigateURL(WebDriver oBrowser, String strURL) {
        try {
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);
            if (oBrowser.getTitle().equalsIgnoreCase("actiTIME - Login")) {
                System.out.println("The url '" + strURL + "' is loaded successful");
                return true;
            } else {
                System.out.println("Failed to load the URL '" + strURL + "'");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception in the 'navigateURL()' method. " + e);
            return false;
        }
    }

    /************************************************************************
     * Method            : loginToApplication()
     * Purpose           : This method performs login action in actiTime application
     * Parameters        : WebDriver oBrowser, String userName, String password
     * Return Type       : boolean
     * Author Name      : Test user
     *************************************************************************/
    public static boolean loginToApplication(WebDriver oBrowser, String userName, String password) {
        try {
            //Login to the application
            oBrowser.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
            oBrowser.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
            oBrowser.findElement(By.xpath("//a[@id='loginButton']")).click();
            Thread.sleep(2000);

            //VErify login is successful
            if (oBrowser.findElement(By.xpath("//input[@id='SubmitTTButton']")).isDisplayed()) {
                System.out.println("Login to ActiTime is successful");
                if (oBrowser.findElements(By.xpath("//div[@style='display: block;']")).size() > 0) {
                    oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
                }
                return true;
            } else {
                System.out.println("Failed to login to actiTime");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception in the 'loginToApplication()' method. " + e);
            return false;
        }
    }
    /************************************************************************
     * Method            : createUser()
     * Purpose           : This method creates new user in actiTime
     * Parameters        : WebDriver oBrowser
     * Return Type       : String
     * Author Name      : Test user
     *************************************************************************/
    public static String createUser(WebDriver oBrowser){
        String userName = null;
        try{
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
            userName = "user1, test";

            //VErify user is created successful
            if(oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).isDisplayed()){
                System.out.println("The new user is created successful");
                return userName;
            }else{
                System.out.println("Failed to create the new user");
                return null;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'createUser()' method. "+ e);
            return null;
        }
    }



    /************************************************************************
     * Method            : deleteUser()
     * Purpose           : This method deletes the user in actiTime
     * Parameters        : WebDriver oBrowser, String userName
     * Return Type       : boolean
     * Author Name       : Test user
     *************************************************************************/
    public static boolean deleteUser(WebDriver oBrowser, String userName){
        try{
            oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//button[contains(text(), 'Delete User')]")).click();
            Thread.sleep(2000);
            oBrowser.switchTo().alert().accept();
            Thread.sleep(2000);


            //VErify user is deleted
            if(oBrowser.findElements(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).size() > 0){
                System.out.println("Failed to delete the user");
                return false;
            }else{
                System.out.println("User is deleted successful");
                return true;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'deleteUser()' method. "+ e);
            return false;
        }
    }


    /************************************************************************
     * Method            : logoutFromActiTime()
     * Purpose           : This method logsout from the actiTime
     * Parameters        : WebDriver oBrowser
     * Return Type       : boolean
     * Author Name       : Test user
     *************************************************************************/
    public static boolean logoutFromActiTime(WebDriver oBrowser){
        try{
            oBrowser.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);

            //VErify logout is successful
            if(oBrowser.findElement(By.id("headerContainer")).getText().equals("Please identify yourself")){
                System.out.println("Logout from the actiTime is successful");
                return true;
            }else{
                System.out.println("Failed to logout form the actiTime");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'logoutFromActiTime()' method. "+ e);
            return false;
        }
    }
    /************************************************************************
     * Method            : getExcelData()
     * Purpose           : This method reads the test data from the Excel file in the for of Map<String, String>
     * Parameters        : String FileNameFile, String sheetName, String logicalName
     * Return Type       : Map<String, String>
     * Author Name       :
     *************************************************************************/
    public static Map<String, String> getExcelData(String fileNameFile, String sheetName, String logicalName){
        FileInputStream fin = null;
        Map<String, String> objMap = null;
        Workbook wb = null;
        Sheet sh = null;
        Row row1 = null;
        Row row2 = null;
        Cell cell1 = null;
        Cell cell2 = null;
        Calendar cal = null;
        String sKey = null;
        String sValue = null;
        int rowNum = 0;
        int colNum = 0;
        try{
            objMap = new HashMap<String, String>();
            fin = new FileInputStream(System.getProperty("user.dir")+"\\testData\\"+fileNameFile+".xlsx");
            wb = new XSSFWorkbook(fin);
            sh = wb.getSheet(sheetName);

            if(sh == null){
                System.out.println("The '"+sheetName+"' sheet doesnot exist");
                return null;
            }

            //find the row Number in which the given logical name exist
            int rowNumber = sh.getPhysicalNumberOfRows();
            for(int r=0; r<rowNumber; r++){
                row1 = sh.getRow(r);
                cell1 = row1.getCell(0);
                if(cell1.getStringCellValue().equalsIgnoreCase(logicalName)){
                    rowNum = r;
                    break;
                }
            }

            if(rowNum > 0){
                row1 = sh.getRow(0);
                row2 = sh.getRow(rowNum);

                colNum = row1.getPhysicalNumberOfCells();
                for(int c=0; c<colNum; c++){
                    cell1 = row1.getCell(c);
                    sKey = cell1.getStringCellValue();

                    cell2 = row2.getCell(c);
                    switch(cell2.getCellType()){
                        case STRING:
                            sValue = cell2.getStringCellValue();
                            break;
                        case BLANK:
                            sValue = "";
                            break;
                        case BOOLEAN:
                            sValue = String.valueOf(cell2.getBooleanCellValue());
                            break;
                        case NUMERIC:
                            if(DateUtil.isCellDateFormatted(cell2)){
                                double dt = cell2.getNumericCellValue();
                                cal = Calendar.getInstance();
                                cal.setTime(DateUtil.getJavaDate(dt));
                                sValue = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);

                            }else{
                                sValue = String.valueOf(cell2.getNumericCellValue());
                            }
                            break;
                    }
                    objMap.put(sKey, sValue);
                }
            }else{
                System.out.println("Failed to find the logicalNam '"+logicalName+"'");
                return null;
            }
            return objMap;
        }catch(Exception e){
            System.out.println("Exception in the 'getExcelData()' method. "+ e);
            return null;
        }finally
        {
            try{
                fin.close();
                fin = null;
                cell1 = null;
                cell2 = null;
                row1 = null;
                row2 = null;
                sh = null;
                wb.close();
                wb = null;
                cal = null;
            }catch(Exception e){}
        }
    }
    public static String createUser(WebDriver oBrowser, Map<String, String> data){
        String userName = null;
        try{
            oBrowser.findElement(By.xpath("//div[text()='USERS']")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//input[@name='firstName']")).sendKeys(data.get("user_FirstName"));
            oBrowser.findElement(By.xpath("//input[@name='lastName']")).sendKeys(data.get("user_lastName"));
            oBrowser.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get("user_email"));
            oBrowser.findElement(By.xpath("//input[@name='username']")).sendKeys(data.get("user_userName"));
            oBrowser.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("user_password"));
            oBrowser.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys(data.get("user_retypePassword"));

            oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
            Thread.sleep(2000);
            userName = data.get("user_lastName")+", "+data.get("user_FirstName");

            //VErify user is created successful
            if(oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).isDisplayed()){
                System.out.println("The new user is created successful");
                return userName;
            }else{
                System.out.println("Failed to create the new user");
                return null;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'createUser()' method. "+ e);
            return null;
        }
    }

}
