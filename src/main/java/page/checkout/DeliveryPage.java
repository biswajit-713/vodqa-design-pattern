package page.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryPage {
    private final WebDriver driver;

    private By saveAndContinue = By.className("checkout-content-save-continue-button");

    public DeliveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement saveAndContinue() {
        return driver.findElement(saveAndContinue);
    }
}
