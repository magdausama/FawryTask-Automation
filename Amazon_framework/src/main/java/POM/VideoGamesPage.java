package POM;

import Actions.SeleniumActions;
import DTO.ElementDTO;
import utils.ConfigUtils;

import java.util.List;

public class VideoGamesPage extends BasePage {

    ElementDTO videoGamesText = new ElementDTO("//b[contains(text(),'Video Games')]", SeleniumActions.Locators.XPath),
    freeShipping = new ElementDTO("//span[text()='Free Shipping']/parent::a//i[@class='a-icon a-icon-checkbox']", SeleniumActions.Locators.XPath),
    newCondition = new ElementDTO("//span[(text()= 'New')]", SeleniumActions.Locators.XPath),
    sortByButton= new ElementDTO("//label[text()='Sort by:']/parent::span//select", SeleniumActions.Locators.XPath),
    resultsText = new ElementDTO("//span[text()='Results']", SeleniumActions.Locators.XPath),
    highToLowChoice = new ElementDTO("//a[text()='Price: High to Low']", SeleniumActions.Locators.XPath),
    prices = new ElementDTO("//span[@class='a-price-whole']/text()[translate(.,',','')<\"15000\"]", SeleniumActions.Locators.XPath),
    elementsNamesWithPriceLessThanFifteenK = new ElementDTO("//span[@class='a-price-whole']/text()[translate(.,',','')<\"15000\"]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-size-medium a-color-base a-text-normal']", SeleniumActions.Locators.XPath),
    addToCartButton = new ElementDTO("add-to-cart-button", SeleniumActions.Locators.id),
    myCartButton = new ElementDTO("nav-cart", SeleniumActions.Locators.id),
    proceedToBuyButton = new ElementDTO("//input[@name='proceedToRetailCheckout']", SeleniumActions.Locators.XPath);



    public VideoGamesPage(String key) {
        super(key);
    }
    public String getVideoGamesText() {
        return seleniumActions.getText(videoGamesText);
    }

    public void chooseSpecificConditionsInVideoGamesPage() throws Exception {
        seleniumActions.clickOn(freeShipping);
        seleniumActions.clickOn(newCondition);
        seleniumActions.clickOn(sortByButton);
        seleniumActions.clickOn(highToLowChoice);
    }

    public String getResultsText() throws Exception {
        return  seleniumActions.getText(resultsText);
    }
    public Double getTotalPricesOfItemsIAddedInMyCart()
    {
        List <String> allPrices = seleniumActions.getElementsText(prices);
        Double sum=0.0;
        for( String price : allPrices)
        {
            sum+=Double.parseDouble(price.replace(",", ""));
        }
return sum;
    }
    public void addToCart() throws Exception {
        List <String> itemNames = seleniumActions.getElementsText(elementsNamesWithPriceLessThanFifteenK);
        for(String name: itemNames)
        {
            seleniumActions.clickOn(new ElementDTO("//span[text()='"+name+"']/parent::a", SeleniumActions.Locators.XPath));
            seleniumActions.clickOn(addToCartButton);
            seleniumActions.navigateToPage(ConfigUtils.getInstance().getvideoGamesURL());
        }

    }

    public CheckoutPage goToCheckoutPage() throws Exception {
        seleniumActions.clickOn(myCartButton);
        seleniumActions.clickOn(proceedToBuyButton);
        return new CheckoutPage(key);
    }

}
