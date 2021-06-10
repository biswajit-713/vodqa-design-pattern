package page.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPage {
    private final WebDriver driver;

    private By placeOrder = By.className("checkout-content-save-continue-button");

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement placeOrder() {
        return driver.findElement(placeOrder);
    }
}
