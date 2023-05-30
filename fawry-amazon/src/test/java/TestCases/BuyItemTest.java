package TestCases;

import com.amazon.Base.TestBase;
import com.amazon.Pages.BuyItemPage;
import com.amazon.Pages.HomePage;
import org.testng.annotations.Test;

public class BuyItemTest extends TestBase {
    @Test
    public void checkIfAllItemsSelected(){
        HomePage homePage = new HomePage(driver);
        homePage
                .loadWebsite()
                .clickOnAll()
                .clickOnFreeShipping()
                .clickOnNewLink()
                .selectDropDown()
                .clickItemLessFifteen();
    }
}
