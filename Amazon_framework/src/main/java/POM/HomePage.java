package POM;

import Actions.SeleniumActions;
import DTO.ElementDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    ElementDTO allFromSideMenu= new ElementDTO("nav-hamburger-menu",SeleniumActions.Locators.id),
    seeAllFromSideMenu = new ElementDTO("//a[@class='hmenu-item hmenu-compressed-btn']", SeleniumActions.Locators.XPath),
    videoGames = new ElementDTO("//div[contains(text(),'Video Games')]", SeleniumActions.Locators.XPath),
    allVideoGames = new ElementDTO("//a[contains(text(),'All Video Games')]", SeleniumActions.Locators.XPath),
    helloNavBarName = new ElementDTO("nav-link-accountList-nav-line-1", SeleniumActions.Locators.id);
    public HomePage(String key) {
        super(key);
    }


    public String getHelloMsg()
    {
        return seleniumActions.getText(helloNavBarName);
    }

    public VideoGamesPage goingToVideoGamesPage() throws Exception {
        seleniumActions.clickOn(allFromSideMenu);
        seleniumActions.clickOn(seeAllFromSideMenu);
        seleniumActions.clickOn(videoGames);
        seleniumActions.clickOn(allVideoGames);
        return new VideoGamesPage(key);

    }




}
