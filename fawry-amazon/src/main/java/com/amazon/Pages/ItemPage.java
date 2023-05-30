package com.amazon.Pages;

import com.amazon.Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends PageBase {
    public ItemPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    public CartPage addToCart(){
        addToCartButton.click();
        return new CartPage(driver);
    }
}
