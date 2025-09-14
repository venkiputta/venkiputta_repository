package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Brokenlink {
    public static void main(String[] args) {
        brokenLink();

    }
    public static void brokenLink(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("https://www.google.co.in/");
            Thread.sleep(2000);

            List<WebElement> oLinks = oBrowser.findElements(By.tagName("a"));
            for(int i=0; i<oLinks.size(); i++){
                //System.out.println(oLinks.get(i).getDomAttribute("href"));
                checkLinks(oLinks.get(i).getDomAttribute("href"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser = null;
        }
    }


    public static void checkLinks(String linkURL){
        URL url = null;
        HttpURLConnection httpConnection = null;
        try{
            url = new URL(linkURL);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setConnectTimeout(3000);
            httpConnection.connect();

            if(httpConnection.getResponseCode() == 200){
                System.out.println(linkURL + " = " + httpConnection.getResponseMessage());
            }

            if(httpConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND){
                System.out.println(linkURL +" = "+ httpConnection.getResponseMessage());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            url = null;
            httpConnection = null;
        }
    }
}
