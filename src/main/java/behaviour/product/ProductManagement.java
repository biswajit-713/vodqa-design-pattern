package behaviour.product;

import exception.FrameworkException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import page.LandingPage;
import page.ProductDetailsPage;
import page.ProductListingPage;

public class ProductManagement {

    private final LandingPage landingPage;
    private final ProductListingPage plp;
    private final ProductDetailsPage pdp;

    public ProductManagement(WebDriver driver) {
        landingPage = new LandingPage(driver);
        plp = new ProductListingPage(driver);
        pdp = new ProductDetailsPage(driver);
    }

    public void addToCart(String item) {
        landingPage.navbar().getSearchIcon().click();
        landingPage.navbar().getSearchBox().click();
        landingPage.navbar().getSearchBox().sendKeys(item);
        landingPage.navbar().getSearchBox().sendKeys(Keys.ENTER);

        if (!plp.isProductListLoaded()) {
            throw new FrameworkException("The product listing page is not loaded");
        }

        plp.getListedProduct().click();
        pdp.addToCart();
    }
}
