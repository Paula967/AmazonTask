package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DetailsItemPage extends BasePage{


    //Constructor
    public DetailsItemPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By productName=By.xpath("//div[@id='title_feature_div']/div/h1/span");
    private final By productPrice =By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']");
    private final By addToCartButton=By.id("add-to-cart-button");
    private final By noThanksButton=By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']");
    private final By seeAllBuyingOptionsButton=By.xpath("//a[@title='See All Buying Options']");
    private final By addToCartButton2=By.xpath("//input[@name='submit.addToCart']");
    private final By viewCartButton=By.cssSelector("#nav-cart");
    private final By productPrice2=By.xpath("//span[@class='a-price aok-align-center centralizedApexPricePriceToPayMargin']//span[@class='a-price-whole']");
    private final By closeButton=By.cssSelector("i[class='a-icon aod-close-button']");

    //Actions
    public String getProductName(){
        waitForElementVisibility(productName);
        return getTextFromElement(productName);
    }

    public Double getProductPrice()  {
        double Value=0;
        try{
           if(isBuyingOptionsAvailable()) {
            clickElement(seeAllBuyingOptionsButton);
            Value= convertTextToDouble(productPrice2);
            clickElement(closeButton);
        }
        } catch (NoSuchElementException e) {
            Value = convertTextToDouble(productPrice);
        }
        return Value;
    }

    public ShoppingCartPage addProductToCart() {
        try{
        if (isBuyingOptionsAvailable()) {
            processBuyingOptions();
        }
        } catch (NoSuchElementException e) {
            processDirectAddToCart();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ShoppingCartPage(driver);
    }

    private void processBuyingOptions() throws InterruptedException {
        clickElement(seeAllBuyingOptionsButton);
        clickElementByJavaScript(addToCartButton2);
        Thread.sleep(1200);
        clickElementByJavaScript(viewCartButton);
    }

    private void processDirectAddToCart() {
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
        clickElementByJavaScript(addToCartButton);
        clickElement(noThanksButton);
        shoppingCartPage.clickGoToBasket();
    }

    private boolean isBuyingOptionsAvailable() {
        return findElement(seeAllBuyingOptionsButton).isDisplayed();
    }

}
