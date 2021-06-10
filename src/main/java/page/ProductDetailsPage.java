package page;

import entity.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailsPage extends Base {
    private WebDriver driver;

    private By size = By.className("select-label");
    private By quantity = By.id("quantity");
    private By addToCart = By.id("add-to-cart-button");
    private By viewCart = By.xpath("//a[contains(text(),'View cart')]");
    private By checkout = By.xpath("//a[contains(text(),'Checkout')]");

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement checkout(){
        return driver.findElement(checkout);
    }

    public List<WebElement> getSizes() {
        return driver.findElements(size);
    }

    public WebElement getQuantity() {
        return driver.findElement(quantity);
    }

    public WebElement addToCart() {
        return driver.findElement(addToCart);
    }

    public WebElement viewCart() {
        return driver.findElement(viewCart);
    }
}
