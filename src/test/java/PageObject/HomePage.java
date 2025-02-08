package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators
     private final By searchTextBox =By.id("twotabsearchtextbox");
     private final By searchButton =By.id("nav-search-submit-button");

    //Actions
    public HomePage searchFor(String Item){
        sendKeysToElement(searchTextBox,Item);
        return this;
    }

    public SearchResultPage clickSearchButton(){
        clickElement(searchButton);
        return new SearchResultPage(driver);
    }
}
