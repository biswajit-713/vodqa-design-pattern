import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.Navbar;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductListingPage;
import resources.Base;
import resources.Utilities;

import java.io.IOException;

public class CartTests extends Base {
    public WebDriver driver;
    private Navbar navbar;
    private ProductListingPage productListingPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;

    @BeforeTest
    public void setDriver() throws IOException {
        this.driver = initialiseDriver();
        this.driver.get(properties.getProperty("base_url"));
        navbar = new Navbar(driver);
        productListingPage = new ProductListingPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(dataProvider = "productList")
    public void addToCartTest(String productName, String productPrice, String productSize) {
        navbar.getSearchIcon().click();
        navbar.getKeywords().sendKeys(productName);
        navbar.getKeywords().sendKeys(Keys.ENTER);

        productListingPage.getProductNames().get(0).click();
        productDetailsPage.getSizeOptions(productSize).click();
        productDetailsPage.getAddToCartButton().click();

        cartPage.getViewCart().click();

        Assert.assertTrue(cartPage.listProductByName(productName));
    }

    @DataProvider(name = "productList")
    public Object[][] getProductList() throws IOException {
        return Utilities.getDataFromExcel(System.getProperty("user.dir")+"/src/main/java/resources/Product Details.xlsx");
    }

    @AfterTest
    public void teardown(){
        this.driver.close();
    }
}
