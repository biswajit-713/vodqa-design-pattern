package page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingDetailsPageComponent {
    private WebDriver driver;

    By editShippingDetails = By.linkText("Edit shipping details");
    By city = By.name("city");
    By next = By.id("next_btnundefined");

    public ShippingDetailsPageComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement editShippingDetails() {
        return this.driver.findElement(editShippingDetails);
    }

    public WebElement city() {
        return this.driver.findElement(city);
    }

    public WebElement next() {
        return this.driver.findElement(next);
    }
}
