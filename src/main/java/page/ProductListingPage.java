package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductListingPage {
    private final WebDriver driver;

    public ProductListingPage(WebDriver driver){
        this.driver = driver;
    }

    private final By buyNow = By.name("buy_now");
    private final By listedProduct = By.id("product_2");
    private final By productList = By.xpath("//div[@data-hook='homepage_products']");

    public boolean isProductListLoaded() {
        return new WebDriverWait(driver, 10).until(d -> d.findElement(productList).isDisplayed());
    }

    public WebElement getListedProduct() {
        return driver.findElement(listedProduct);
    }
}
