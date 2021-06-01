package behaviour.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart {
    private final WebDriver driver;

    private final By checkout = By.id("checkOutButton");

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout() {
        driver.findElement(checkout).click();
    }
}
