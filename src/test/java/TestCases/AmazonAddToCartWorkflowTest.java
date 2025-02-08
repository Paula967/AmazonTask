package TestCases;

import PageObject.DetailsItemPage;
import PageObject.ShoppingCartPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;


public class AmazonAddToCartWorkflowTest extends BaseClass {
    @Test
    public void AddToCartTest() throws InterruptedException {

        DetailsItemPage detailsItemPage = homePage
                .searchFor("iPad")
                .clickSearchButton()
                .sortItemsBy("Price: High to Low")
                .clickSearchResult(1);

        String expectedProductName = detailsItemPage.getProductName();
        Double expectedProductPrice = detailsItemPage.getProductPrice();

        ShoppingCartPage cartPage = detailsItemPage.addProductToCart();


        boolean isProductNameMatching = expectedProductName.contains(cartPage.getCartProductName());
        boolean isProductPriceMatching = Objects.equals(expectedProductPrice, cartPage.getCartProductPrice());

        Assert.assertTrue(isProductNameMatching && isProductPriceMatching, "No Matched Data");

    }
}
