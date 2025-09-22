package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UtilityMethods {
    public static WebDriver launchBrowser(String browserName){
        WebDriver oDriver = null;
        switch(browserName.toLowerCase()){
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
                System.out.println("Invalid browser name '"+browserName+"' was specified");
        }
        if(oDriver!=null){
            oDriver.manage().window().maximize();
            System.out.println("The '"+browserName+"' browser launched successful");
            return oDriver;
        }else{
            System.out.println("Failed to launch the '"+browserName+"' browser");
            return null;
        }
    }


    public static boolean navigateURL(WebDriver oBrowser, String strURL){
        try{
            oBrowser.navigate().to(strURL);
            Thread.sleep(2000);
            if(oBrowser.getTitle().equalsIgnoreCase("actiTIME - Login")){
                System.out.println("URL loaded successful");
                return true;
            }else{
                System.out.println("Failed to load the URL '"+strURL+"'");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in 'navigateURL()' method. "+ e);
            return false;
        }
    }

}
