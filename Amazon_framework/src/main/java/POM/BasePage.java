package POM;

import Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    SeleniumActions seleniumActions;
    String key;
    public BasePage(String key)
    {
        seleniumActions = new SeleniumActions(key);
        this.key = key;
    }

}
