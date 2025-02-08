package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultPage extends BasePage{

    //Constructor
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    //Locators
   private final By sortByDropdown =
            By.cssSelector("#s-result-sort-select");
                 By searchResultsLinks =
            By.xpath("(//a[@class='a-link-normal s-line-clamp-4 s-link-style a-text-normal'])");

    //Actions
    public SearchResultPage sortItemsBy(String Value) {
        Select select = new Select(findElement(sortByDropdown));
        select.selectByVisibleText(Value);
        return this;
    }
    public DetailsItemPage clickSearchResult(int index)  {
        waitForElementsVisibility(searchResultsLinks);
        List<WebElement> links = findElements(searchResultsLinks);
        validateIndex(index, links.size());
        links.get(index - 1).click();
        return new DetailsItemPage(driver);
    }
    private void validateIndex(int index, int listSize) {
        if (index < 1 || index > listSize) {
            throw new IllegalArgumentException("Invalid index: " + index + ". Must be between 1 and " + listSize);
        }
    }
}
