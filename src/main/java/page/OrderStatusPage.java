package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class OrderStatusPage {

    private final WebDriver driver;

    private By status = By.xpath("//div[@id='order_summary']/h5");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getStatus() {
        return driver.findElement(status);
    }
}
