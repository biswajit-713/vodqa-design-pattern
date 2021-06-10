package behaviour.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
    private final WebDriver driver;

    private final By checkout = By.id("checkOutButton");
    private final By shoppingCartHeader = By.className("shopping-cart-header");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout() {
        driver.findElement(checkout).click();
    }

    public WebElement getShoppingCartHeader() {
        return driver.findElement(shoppingCartHeader);
    }

    public boolean isDisplayed() {
        return new WebDriverWait(driver, 10).until(d -> d.findElement(shoppingCartHeader).isDisplayed());
    }
}
