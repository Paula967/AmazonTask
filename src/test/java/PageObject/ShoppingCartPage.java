package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ShoppingCartPage extends BasePage{

    //Constructor
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By goToBasektButton=By.xpath("//a[@href='/-/en/cart?ref_=sw_gtc']");
    private final By productInfoInCart =By.xpath("//span[@class='a-truncate-cut']");
    private final By productPriceInCart =By.xpath("//span[@class='a-price a-text-price sc-product-price sc-white-space-nowrap a-size-medium']" +
            "/span[2]");

    //Actions
    public void clickGoToBasket(){
        clickElement(goToBasketButton);
    }
    public String getCartProductName(){
        String data = getTextFromElement(productInfoInCart);
        return data.contains("…") ? data.replace("…", "") : data;
    }

    public Double getCartProductPrice() {
        return convertTextToDouble(productPriceInCart);
    }

}
