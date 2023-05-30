package Tests;

import POM.CheckoutPage;
import POM.HomePage;
import POM.LoginPage;
import POM.VideoGamesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigUtils;

public class CheckoutTests extends BaseTests{
    VideoGamesPage videoGamesPage;
    CheckoutPage checkoutPage;
    @Test
    public void testSuccessfulTotalAmountOfitemsInMyCart() throws Exception {


        HomePage homePage = loginPage.login();
        videoGamesPage = homePage.goingToVideoGamesPage();
        videoGamesPage.chooseSpecificConditionsInVideoGamesPage();
        videoGamesPage.addToCart();
        checkoutPage= videoGamesPage.goToCheckoutPage();
        Assert.assertTrue(checkoutPage.getTitleofCheckOutPage().contains("Checkout"));
        checkoutPage.addAddress();
        checkoutPage.addPaymentMethod();
        Assert.assertEquals(checkoutPage.getOrderTotal(), videoGamesPage.getTotalPricesOfItemsIAddedInMyCart());
    }
    }
