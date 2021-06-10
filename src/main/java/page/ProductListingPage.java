package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage {
    private final WebDriver driver;

    public ProductListingPage(WebDriver driver){
        this.driver = driver;
    }

    private final By buyNow = By.name("buy_now");
    private final By listedProduct = By.id("product_1");
    private final By productImage = By.className("product-component-image");

    public boolean isProductListLoaded() {
        return new WebDriverWait(driver, 10).until(d -> d.findElement(productImage).isDisplayed());
    }

    public WebElement getListedProduct() {
        return driver.findElement(listedProduct);
    }
}
