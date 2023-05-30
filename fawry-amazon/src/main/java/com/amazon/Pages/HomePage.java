package com.amazon.Pages;

import com.amazon.Base.PageBase;
import com.amazon.Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-main']/div[1]/a[1]/i[1]")
    private WebElement AllButton;

    @FindBy(xpath = "//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[1]/li[14]/a[1]")
    private WebElement seeAll;

    @FindBy(xpath = "//div[contains(text(),'Video Games')]")
    private WebElement videoGames;

    @FindBy(xpath = "//a[contains(text(),'All Video Games')]")
    private WebElement allVideoGames;







    public VideoGamesPage clickOnAll(){
        AllButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        seeAll.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        videoGames.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        allVideoGames.click();
        try {
            Thread.sleep(Long.parseLong("3000"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new  VideoGamesPage(driver);
    }

}
