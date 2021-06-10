package behaviour.product;

import behaviour.cart.ShoppingCartPage;
import com.google.common.util.concurrent.Uninterruptibles;
import entity.Product;
import exception.SpreeTestException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LandingPage;
import page.ProductDetailsPage;
import page.ProductListingPage;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ProductManagement {

    private final LandingPage landingPage;
    private final ProductListingPage plp;
    private final ProductDetailsPage pdp;
    private final ShoppingCartPage shoppingCartPage;

    public ProductManagement(WebDriver driver) {
        landingPage = new LandingPage(driver);
        plp = new ProductListingPage(driver);
        pdp = new ProductDetailsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    public void addToCart(Product product) {
        landingPage.navbar().getSearchIcon().click();
        landingPage.navbar().getSearchBox().click();
        landingPage.navbar().getSearchBox().sendKeys(product.getName());
        landingPage.navbar().getSearchBox().sendKeys(Keys.ENTER);

        if (!plp.isProductListLoaded()) {
            throw new SpreeTestException("The product listing page is not loaded");
        }

        plp.getListedProduct().click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        selectSize(product.getSize());
        selectQuantity(product.getQuantity());
        pdp.addToCart().click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        pdp.checkout().click();

    }

    private void selectSize(String size) {
        Optional<WebElement> match = pdp.getSizes().stream()
                .filter(sizeDisplayed -> sizeDisplayed.getAttribute("aria-label").equalsIgnoreCase(size))
                .findFirst();

        if (!match.isPresent()) {
            throw new SpreeTestException("no item with size found");
        }
        match.get().click();
    }

    private void selectQuantity(int quantitiesToBeAdded) {
        pdp.getQuantity().clear();
        pdp.getQuantity().sendKeys(String.valueOf(quantitiesToBeAdded));
    }
}
