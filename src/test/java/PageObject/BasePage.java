package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;



public class BasePage {

    //Attributes
    public WebDriver driver;
    protected  WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Actions
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public void clickElement(By locator){
        findElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    public String getTextFromElement(By locator){
        return findElement(locator).getText();
    }

    public void waitForElementVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public double convertTextToDouble(By locator){
        return Double.parseDouble(getTextFromElement(locator).replaceAll("[^0-9.]", ""));
    }

    public List<WebElement> findElements(By locator)
    {
        return driver.findElements(locator);
    }

    public void clickElementByJavaScript(By locator){
        WebElement Element=driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Element);
    }

    public void waitForElementsVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
