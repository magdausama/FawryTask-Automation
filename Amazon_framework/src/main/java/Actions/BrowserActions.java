package Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class BrowserActions {
    public static Map<String,RemoteWebDriver> driverMap = new HashMap<>();
    static boolean chromeDriverSetUp = false,
            firefoxDriverSetUp = false;
    public static void addWebDriverToMapOfDrivers(Browsers browser, String uniqueKey) {
        if(browser==Browsers.chrome) {
            if(!chromeDriverSetUp){
                WebDriverManager.chromedriver().setup();
                BrowserActions.chromeDriverSetUp = true;
            }
            //adding a new driver to the map and link it with a unique key
            if(!driverMap.containsKey(uniqueKey)) {
                driverMap.put(uniqueKey, new ChromeDriver());
            }
            else{
                driverMap.replace(uniqueKey,new ChromeDriver());
            }
        }
        else if(browser==Browsers.firefox) {
            if(!firefoxDriverSetUp){
                WebDriverManager.firefoxdriver().setup();
                BrowserActions.firefoxDriverSetUp = true;
            }
            if(!driverMap.containsKey(uniqueKey)) {
                driverMap.put(uniqueKey, new FirefoxDriver());
            }
            else{
                driverMap.replace(uniqueKey,new FirefoxDriver());
            }
        }
    }
    public static void closeDriverAndRemoveFromMap(String key){
        if(driverMap.containsKey(key)) {
            try {
                driverMap.get(key).quit();
            }
            catch(Exception e){

            }
            driverMap.remove(key);
        }
    }

    public static void closeAllDriversFromMap(){
        Set<String> keys = driverMap.keySet();
        if(keys!=null && keys.size()>0) {
            for (String key:keys) {
                try {
                    driverMap.get(key).quit();
                } catch (Exception e) {

                }
                driverMap.remove(key);
            }
        }
    }

    public enum Browsers{
        chrome,
        firefox
    }
}
