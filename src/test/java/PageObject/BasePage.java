package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {

    //Attributes
    public WebDriver driver;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public WebElement getFindElement(By locator){
        return driver.findElement(locator);
    }
    public void clickElement(By locator){
        getFindElement(locator).click();
    }
    public void sendKeysToElement(By locator, String text){
        getFindElement(locator).sendKeys(text);
    }
    public String getTextFromElement(By locator){
        return getFindElement(locator).getText();
    }
    public void CheckVisibilityOfElementByExplicitWait(By Element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
    }
    public double ConvertStringDataToNumeric(By Element){
        String CleanString= getTextFromElement(Element).replaceAll("[^0-9.]", "");
        return Double.parseDouble(CleanString);
    }
    public List<WebElement> getFindElements(By Elements)
    {
        return driver.findElements(Elements);
    }



}
