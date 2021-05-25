package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListingPage extends Base {
    private WebDriver driver;

    public ProductListingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-hook='homepage_products']")
    private WebElement productList;

    @FindBy(className = "plp-not-found-header")
    private WebElement noProductsFoundHeader;

    @FindBy(className = "plp-not-found-text")
    private WebElement noProductsFoundText;

    @FindAll({@FindBy(className = "product-component-name")})
    private List<WebElement> productNames;

    public WebElement getProductList(){
        return productList;
    }

    public WebElement getNoProductsFoundHeader(){
        return noProductsFoundHeader;
    }

    public WebElement getNoProductsFoundText(){
        return noProductsFoundText;
    }

    public List<WebElement> getProductNames() { return productNames;}
}
