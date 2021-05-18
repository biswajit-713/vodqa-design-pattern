package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Base;

public class Navbar extends Base {
    private WebDriver driver;

    public Navbar (WebDriver driver) {
        this.driver = driver;
    }

    private By accountIcon = By.id("menuUserLink");

    private By searchIcon = By.id("search");

    private By keywords = By.id("autoComplete");

    public WebElement getAccountIcon(){
        return driver.findElement(accountIcon);
    }

    public WebElement getSearchIcon(){
        return driver.findElement(searchIcon);
    }

    public WebElement getKeywords(){
        return driver.findElement(keywords);
    }
}
