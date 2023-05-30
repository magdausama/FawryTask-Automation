package TestCases;

import com.amazon.Base.TestBase;
import com.amazon.Pages.HomePage;
import com.amazon.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void navigateToVideoGamesPage() {

        LoginPage loginPage = new LoginPage(driver);
        boolean isDisplayed = loginPage
                .loadWebsite()
                .login()
                .clickOnAll()
                .videoGameTextIsDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}
