package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ShoppingCartPage extends BasePage{

    //Constructor
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    //Locators
    By goToBasket_btn=By.xpath("//a[@href='/-/en/cart?ref_=sw_gtc']");
    By ProductInfoInCartPage=By.xpath("//span[@class='a-truncate-cut']");
    By ProductPriceInCartPage=By.xpath("//span[@class='a-price a-text-price sc-product-price sc-white-space-nowrap a-size-medium']" +
            "/span[2]");
    //Actions
    public ShoppingCartPage ClickOnMyCartButton(){
        Click(goToBasket_btn);
        return this;
    }
    public String getProductInfo(){
        String data = getData(ProductInfoInCartPage);
        return data.contains("…") ? data.replace("…", "") : data;
    }
    public Double getProductPrice() {
        return ConvertToNumeric(ProductPriceInCartPage);
    }
}
