package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

public class Navbar extends Base {
    private WebDriver driver;

    public Navbar (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#account-button")
    private WebElement accountIcon;

    @FindBy(css = "a[href*=signup]")
    private WebElement signUp;

    @FindBy(css = "a[href*=login]")
    private WebElement login;

    @FindBy(css = "a[href*=logout]")
    private WebElement logout;

    @FindBy(className = "search-icons")
    private WebElement searchIcon;

    @FindBy(id = "keywords")
    private WebElement keywords;

    public WebElement getAccountIcon(){
        return accountIcon;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getSignUp(){
        return signUp;
    }

    public WebElement getSearchIcon(){
        return searchIcon;
    }

    public WebElement getKeywords(){
        return keywords;
    }
}
