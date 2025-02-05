package TestCases;

import PageObject.DetailsItemPage;
import PageObject.ShoppingCartPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;


public class AmazonAddToCartWorkflowTest extends BaseClass {
    @Test
    public void AddToCartTest(){
        DetailsItemPage detailsItemPage= homePage.SendData().ClickOnSearchButton().selectByVisibleText().ClickOnFirstSearchResult();
        String ProductName=detailsItemPage.getProductName();
        Double ProductPrice=detailsItemPage.getProductPrice();
        ShoppingCartPage shoppingCartPage=detailsItemPage.ClickOnAddToCart().ClickOnMyCartButton();
        Assert.assertTrue(ProductName.contains(shoppingCartPage.getProductInfo()) && Objects.equals(ProductPrice, shoppingCartPage.getProductPrice()),"No Matched Data");
    }
}
