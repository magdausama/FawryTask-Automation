package Actions;
import DTO.ElementDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class SeleniumActions {
    RemoteWebDriver driver;
    Duration tenSeconds = Duration.of(10, ChronoUnit.SECONDS);
    public SeleniumActions(String key){
        this.driver = BrowserActions.driverMap.get(key);

    }
    public void setText(ElementDTO ele, String text, boolean clear) throws Exception {
        By b = returnElementLocatorBy(ele.selector,ele.locator);
        WebElement element = waitUntil(b, ExpectedConditionsEnum.presenceOfElement);
        if(element !=null) {
                if (clear)
                    element.clear();
                element.sendKeys(text);

        }
        else{
            String message = String.format("Element with selector: %s is null",ele.selector);
            throw new Exception(message);

        }
    }
    public void sendKeys(ElementDTO ele, Keys key) throws Exception {
        By b = returnElementLocatorBy(ele.selector,ele.locator);
        WebElement element = waitUntil(b, ExpectedConditionsEnum.presenceOfElement);
        if(element!=null)
            element.sendKeys(key);
        else{
            String message = String.format("Element with selector: %s is null",ele.selector);
            throw new Exception(message);
        }

    }
    public void clickOn(ElementDTO ele) throws Exception {

        By b = returnElementLocatorBy(ele.selector,ele.locator);
        WebElement element = waitUntil(b, ExpectedConditionsEnum.ElementToBeClickable);
        if(element!=null) {
            try {
                element.click();
            } catch (Exception e) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", element);

            }
            new WebDriverWait(driver, tenSeconds).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        else{
            String message = String.format("Element with selector: %s is null",ele.selector);
            throw new Exception(message);
        }
    }
    public WebElement waitUntil(By b, ExpectedConditionsEnum condition, String... attribute) {
        try {
            WebElement element = null;
            switch (condition) {
                case presenceOfElement:
                    element = (new WebDriverWait(driver,tenSeconds)).until(ExpectedConditions.presenceOfElementLocated(b));
                    return element;
                case ElementToBeClickable:
                    element = (new WebDriverWait(driver, tenSeconds)).until(ExpectedConditions.elementToBeClickable(b));
                    return element;
                case visibilityOfElementLocated:
                    element = (new WebDriverWait(driver, tenSeconds)).until(ExpectedConditions.visibilityOfElementLocated(b));
                    return element;
                case attributeToBeNotEmpty:
                    boolean flag = (new WebDriverWait(driver, tenSeconds)).until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(b), attribute[0]));
                    if (flag) element = driver.findElement(b);
                    else element=null;
                    return element;
                case invisibilityOfElementLocated:
                    boolean f = (new WebDriverWait(driver, tenSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(b));
                    if (f) element = driver.findElement(b);
                    return element;
                    default:
                    element = null;
            }
            return element ;
        } catch (Exception e) {
            return null;
        }
    }
    public String getText(ElementDTO ele){
        try{
            By b = returnElementLocatorBy(ele.selector,ele.locator);
            WebElement element = waitUntil(b,ExpectedConditionsEnum.presenceOfElement);
            if(element!=null) {
                return element.getText();
            }
            else {
                return null;
            }

        }
        catch (Exception e){
            return null;
        }
    }
    public void navigateToPage(String url) {
        driver.get(url);
        new WebDriverWait(driver, tenSeconds).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public By returnElementLocatorBy(String selector,Locators l){
        switch (l){
            case XPath:
                return new By.ByXPath(selector);

            case id:
                return new By.ById(selector);

            case className:
                return new By.ByClassName(selector);


            case CSS:
                return new By.ByCssSelector(selector);


            default: return  null;
        }
    }
    public List<String> getElementsText (ElementDTO ele){
        waitUntil(returnElementLocatorBy(ele.selector,ele.locator), ExpectedConditionsEnum.presenceOfElement);
        List<WebElement> elements = driver.findElements(returnElementLocatorBy(ele.selector, ele.locator));
        List<String> textList= new ArrayList<>();
        if (elements!= null) {
            for (WebElement element : elements) {
                textList.add(element.getText());
            }
        }
        return textList;
    }
    public List <WebElement> getWebElementsThatMatchASpecificCondition(ElementDTO ele, Double d)
    {
        waitUntil(returnElementLocatorBy(ele.selector,ele.locator), ExpectedConditionsEnum.presenceOfElement);
        List<WebElement> elements = driver.findElements(returnElementLocatorBy(ele.selector, ele.locator));
        List <WebElement> elementsReturned= new ArrayList<>();
        for(WebElement element: elements)
        {
            if(Double.parseDouble(element.getText())<=d)
                elementsReturned.add(element);
        }
        return elementsReturned;

    }
    public boolean isElementExist(ElementDTO ele){
        return (!driver.findElements(
                returnElementLocatorBy(ele.selector,ele.locator)
        ).isEmpty());
    }
    public boolean clickOnListOfButtons(ElementDTO ele){
        try {


            By b = returnElementLocatorBy(ele.selector, ele.locator);
            List<WebElement> elements = driver.findElements(b);
            if (elements != null && elements.size() > 0) {
                for (int i = 0; i < elements.size(); i++) {
                    elements.get(i).click();
                }
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public String getAttribute(ElementDTO ele, String attribute){
        if(isElementExist(ele)){
            return
                    driver.findElement(returnElementLocatorBy(ele.selector,ele.locator))
                            .getAttribute(attribute);
        }
        return null;
    }
    public enum Locators {
        XPath,
        CSS,
        id,
        className
    }
    public enum ExpectedConditionsEnum{
        presenceOfElement,
        ElementToBeClickable,
        visibilityOfElementLocated,
        attributeToBeNotEmpty,
        invisibilityOfElementLocated}

}
