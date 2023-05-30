package com.amazon.Pages;


import com.amazon.Base.PageBase;
import com.amazon.Utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BuyItemPage extends PageBase {

    private static By inventoryItemsPrice = new By.ByClassName("a-price-whole");

    public BuyItemPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    public ItemPage clickItemLessFifteen() {
        List<WebElement> priceElements = driver.findElements(inventoryItemsPrice);
        ArrayList<WebElement> selectedElements = new ArrayList<>();

        for (WebElement element : priceElements) {
            int price = Integer.parseInt(element.getText().replace(",", ""));
            if (price < 15000) {
                selectedElements.add(element);
            }
        }
        for (WebElement element : selectedElements) {
            System.out.println(element.getText());
        }

        for (WebElement element : selectedElements) {
                element.click();
                addToCartButton.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                driver.navigate().to(ConfigUtils.getInstance().getItemsUrl());
        }
        return new ItemPage(driver);
    }
}
