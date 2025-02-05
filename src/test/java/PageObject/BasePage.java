package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    //Attributes
    public WebDriver driver;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public WebElement getFindElement(By Element){
        return driver.findElement(Element);
    }
    public void Click(By Element){
        getFindElement(Element).click();
    }
    public void SendDataToTextBox(By Element, String Word){
        getFindElement(Element).sendKeys(Word);
    }
    public String getData(By Element){
        return getFindElement(Element).getText();
    }
    public void ExplicitWaitFunction(By Element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
    }
    public double ConvertToNumeric(By Element){
        String CleanString=getData(Element).replaceAll("[^0-9.]", "");
        return Double.parseDouble(CleanString);
    }


}
