package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsItemPage extends BasePage{

    //Constructor
    public DetailsItemPage(WebDriver driver) {
        super(driver);
    }
    //Locators
    By iPad_Name=By.xpath("//div[@id='title_feature_div']/div/h1/span");
    By iPad_Salary =By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']");
    By addToCart_btn=By.id("add-to-cart-button");
    By NoThanks_btn=By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']");

    //Actions
    public String getProductName(){
        ExplicitWaitFunction(iPad_Name);
        return getData(iPad_Name);
    }
    public Double getProductPrice(){
        return ConvertToNumeric(iPad_Salary);
    }
    public ShoppingCartPage ClickOnAddToCart(){
        Click(addToCart_btn);
        Click(NoThanks_btn);
        return new ShoppingCartPage(driver);
    }


}
