package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "shopping-cart-total-amount")
    private WebElement cartTotal;

    @FindAll({@FindBy(className = "item-title")})
    private List<WebElement> productNames;

    @FindAll({@FindBy(className = "product-added-modal-button")})
    private List<WebElement> cartOptions;

    public WebElement getCartTotal(){
        return cartTotal;
    }

    public boolean listProductByName(String productName){
        return productNames.stream().anyMatch(el -> el.getText().equals(productName));
    }

    public WebElement getViewCart(){
        return cartOptions.get(1);
    }
}
