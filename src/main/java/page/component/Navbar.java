package page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BootStrap;

public class Navbar extends BootStrap {
    private WebDriver driver;

    public Navbar (WebDriver driver) {
        this.driver = driver;
    }

    private final By accountIcon = By.id("account-button");
    private final By signUp = By.linkText("SIGN UP");
    private final By login = By.linkText("LOG IN");

    private final By searchIcon = By.className("search-icons");
    private final By searchBox = By.id("keywords");

    private final By keywords = By.id("autoComplete");
    private final By user = By.className("hi-user");

    public WebElement getAccountIcon(){
        return driver.findElement(accountIcon);
    }

    public WebElement getSignUp() {
        return driver.findElement(signUp);
    }

    public WebElement getLogin() {
        return driver.findElement(login);
    }

    public WebElement getSearchIcon(){
        return driver.findElement(searchIcon);
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    public WebElement getKeywords(){
        return driver.findElement(keywords);
    }

    public WebElement getUser () {
        return driver.findElement(user);
    }

    public boolean isLoaded() {
        return new WebDriverWait(this.driver, 30).until(d -> d.findElement(accountIcon).isDisplayed());
    }
}
