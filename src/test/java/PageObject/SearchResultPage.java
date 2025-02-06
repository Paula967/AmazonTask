package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchResultPage extends BasePage{

    //Constructor
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By SortBy_dropDownList=
            By.cssSelector("#s-result-sort-select");
    By First_Search_iPadResult_lnk=
            By.xpath("(//a[@class='a-link-normal s-line-clamp-4 s-link-style a-text-normal'])[8]");



    //Actions
    public SearchResultPage SortingItemsBy(String Value) {
        Select select = new Select(getFindElement(SortBy_dropDownList));
        select.selectByVisibleText(Value);
        return this;
    }
    public DetailsItemPage ClickOnFirstSearchResult(){
        Click(First_Search_iPadResult_lnk);
        return new DetailsItemPage(driver);
    }

}
