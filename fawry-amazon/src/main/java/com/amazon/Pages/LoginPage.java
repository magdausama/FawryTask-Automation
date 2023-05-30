package com.amazon.Pages;

import com.amazon.Base.PageBase;
import com.amazon.Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton2;

    public LoginPage loadWebsite(){
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    public HomePage login(){
        signInButton.click();
        phoneField.sendKeys(ConfigUtils.getInstance().getPhoneNumber());
        continueButton.click();
        passwordField.sendKeys(ConfigUtils.getInstance().getPassword());
        signInButton2.click();

        return new HomePage(driver);

    }

}


