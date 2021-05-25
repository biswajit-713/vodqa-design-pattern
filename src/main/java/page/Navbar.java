package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navbar extends Base {
    private WebDriver driver;

    public Navbar (WebDriver driver) {
        this.driver = driver;
    }

    private final By accountIcon = By.id("menuUserLink");
    private final By searchIcon = By.id("search");
    private final By keywords = By.id("autoComplete");
    private final By user = By.className("hi-user");

    public WebElement getAccountIcon(){
        return driver.findElement(accountIcon);
    }

    public WebElement getSearchIcon(){
        return driver.findElement(searchIcon);
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
