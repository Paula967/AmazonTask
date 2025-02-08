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

        DetailsItemPage detailsItemPage= homePage
               .searchFor("iPad")
               .clickSearchButton()
               .sortItemsBy("Price: High to Low")
               .clickSearchResult(2);

        String ProductName=detailsItemPage.getProductName();
        Double ProductPrice=detailsItemPage.getProductPrice();

        ShoppingCartPage shoppingCartPage=detailsItemPage
                .addProductToCart();

        Assert.assertTrue(ProductName.contains(shoppingCartPage.getCartProductName())
                && Objects.equals(ProductPrice, shoppingCartPage.getCartProductPrice()),"No Matched Data");
    }
}
