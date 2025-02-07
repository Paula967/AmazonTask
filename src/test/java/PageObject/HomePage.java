package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By Search_txtBox =By.id("twotabsearchtextbox");
    By Search_btn=By.id("nav-search-submit-button");

    //Actions
    public HomePage SearchFor(String Item){
        sendKeysToElement(Search_txtBox,Item);
        return this;
    }
    public SearchResultPage ClickOnSearchButton(){
        clickElement(Search_btn);
        return new SearchResultPage(driver);
    }

}
