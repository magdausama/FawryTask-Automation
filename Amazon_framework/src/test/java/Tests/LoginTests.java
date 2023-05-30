package Tests;
import POM.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTests{
    @Test
    public void testSuccessfulLogin() throws Exception {

        HomePage homePage= loginPage.login();
        Assert.assertTrue(!homePage.getHelloMsg().contains("sign"));

    }
}
