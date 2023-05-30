package Tests;

import Actions.BrowserActions;
import Actions.SeleniumActions;
import POM.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigUtils;

public class BaseTests {
    String key;
    SeleniumActions seleniumActions;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp()
    {
        key =  Long.toString(Thread.currentThread().getId());
        BrowserActions.addWebDriverToMapOfDrivers(BrowserActions.Browsers.chrome,key);
        seleniumActions = new SeleniumActions(key);
        seleniumActions.navigateToPage(ConfigUtils.getInstance().getBaseUrl());
        loginPage = new LoginPage(key);

    }

    @AfterMethod
    public void tearDown()
    {
        BrowserActions.closeDriverAndRemoveFromMap(key);
    }
}
