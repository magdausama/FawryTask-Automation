package TestCases;

import com.amazon.Base.TestBase;
import com.amazon.Pages.HomePage;
import com.amazon.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VideoGamesTest extends TestBase {


    @Test
    public void clickOnFreeShipping() {
        LoginPage loginPage = new LoginPage(driver);

        boolean resultText = loginPage
                .loadWebsite()
                .login()
                .clickOnAll()
                .clickOnFreeShipping()
                .resultTextIsDisplayed();
        Assert.assertTrue(resultText);

    }
    @Test
    public void clickOnDropDown(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .loadWebsite()
                .login()
                .clickOnAll()
                .clickOnFreeShipping()
                .clickOnNewLink()
                .selectDropDown();
    }

}
