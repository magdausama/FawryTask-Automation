package POM;

import Actions.SeleniumActions;
import DTO.ElementDTO;
import utils.ConfigUtils;

public class LoginPage extends BasePage {


    //elements
    ElementDTO signInNavBarButton = new ElementDTO("nav-link-accountList",SeleniumActions.Locators.id),
    emailField = new ElementDTO("//input[@id='ap_email']", SeleniumActions.Locators.XPath),
    passwordField = new ElementDTO("//input[@id='ap_password']",SeleniumActions.Locators.XPath),
    signInSubmitButton = new ElementDTO("signInSubmit", SeleniumActions.Locators.id),
    continueButton = new ElementDTO("continue", SeleniumActions.Locators.id),
    changeLanguageButton= new ElementDTO("icp-nav-flyout", SeleniumActions.Locators.id),
    englishRadioButton = new ElementDTO("//input[@value='en_AE']", SeleniumActions.Locators.XPath),
    saveChangesButton = new ElementDTO("icp-save-button-announce", SeleniumActions.Locators.id);
    public LoginPage(String key) {
        super(key);
    }

    public HomePage login() throws Exception {
        seleniumActions.clickOn(changeLanguageButton);
        seleniumActions.clickOn(englishRadioButton);
        seleniumActions.clickOn(saveChangesButton);
        Thread.sleep(2000);
        seleniumActions.clickOn(signInNavBarButton);
        seleniumActions.setText(emailField, ConfigUtils.getInstance().getEmail(), true);
        seleniumActions.clickOn(continueButton);
        seleniumActions.setText(passwordField, ConfigUtils.getInstance().getPassword(), true);
        seleniumActions.clickOn(signInSubmitButton);
        return new HomePage(key);
    }


}
