package page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OurProducts {

    private WebDriver driver;

    private final By ourProducts = By.className("shop_now");

    public OurProducts(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getOurProducts() {
        return driver.findElements(ourProducts);
    }

}
