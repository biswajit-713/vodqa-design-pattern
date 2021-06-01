package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends Base {
    private WebDriver driver;

    private By addToCartButton = By.name("save_to_cart");
    private By checkout = By.id("check_out_btn");

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    private WebElement getAddToCartButton(){
        return driver.findElement(addToCartButton);
    }

    private WebElement checkout(){
        return driver.findElement(checkout);
    }

    public void addToCart() {
        getAddToCartButton().click();
        checkout().click();
    }
}
