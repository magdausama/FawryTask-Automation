package com.amazon.Factory;

import com.amazon.Utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver initializeDriver() {
        String browser = System.getProperty("browser", "CHROME");
        switch (browser) {
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "CHROME":
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.get(ConfigUtils.getInstance().getBaseUrl());
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser isn't supported");

        }
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }
}
