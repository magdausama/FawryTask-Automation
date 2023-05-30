package TestCases;

import com.amazon.Base.TestBase;
import com.amazon.Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginToWebSite() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .loadWebsite()
                .login();
    }
}