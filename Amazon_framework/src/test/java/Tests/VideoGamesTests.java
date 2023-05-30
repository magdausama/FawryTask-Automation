package Tests;

import POM.CheckoutPage;
import POM.HomePage;
import POM.LoginPage;
import POM.VideoGamesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigUtils;

public class VideoGamesTests extends  BaseTests{
   VideoGamesPage videoGamesPage;
 //  CheckoutPage checkoutPage;
    @Test
    public void testSuccessfulReturnedResultsOfVideoGames() throws Exception {


        videoGamesPage= loginPage.login().goingToVideoGamesPage();
        videoGamesPage.chooseSpecificConditionsInVideoGamesPage();
        //videoGamesPage.addToCart();
        //checkoutPage= videoGamesPage.goToCheckoutPage();
        //Assert.assertTrue(checkoutPage.getTitleofCheckOutPage().contains("Checkout"));
      Assert.assertTrue(videoGamesPage.getResultsText().contains("Results"));


    }
}
