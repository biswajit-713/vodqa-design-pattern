package spreetest;

import behaviour.payment.OrderCheckout;
import behaviour.payment.OrderCheckoutWithCheck;
import behaviour.payment.OrderCheckoutWithCreditCard;
import behaviour.product.ProductManagement;
import behaviour.usermanagement.ShopperManagement;
import com.google.common.util.concurrent.Uninterruptibles;
import entity.Product;
import entity.Shopper;
import drivermanagement.factory.DriverManagerFactory;
import drivermanagement.factory.DriverManagerFactoryImpl;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import spreetest.base.BaseTest;
import utilities.Utilities;

import java.util.concurrent.TimeUnit;

public class PlaceOrderTests extends BaseTest {

    private ProductManagement productManagement;
    private ShopperManagement shopperManagement;
    private OrderCheckout checkout;

    @Test
    public void buyUsingCheckTest() {

        Shopper existingShopper = new Shopper.builder("spree@spree.com", "spree123").build();
        Product productToBuy = new Product.builder().name("Oversize Sweatshirt").size("XL").quantity(2).build();

        productManagement = new ProductManagement(driver);
        shopperManagement = new ShopperManagement(driver);

        shopperManagement.loginAs(existingShopper);
        productManagement.addToCart(productToBuy);
        checkout = new OrderCheckoutWithCheck(driver);
        String status = checkout.placeOrder();

        Assert.assertEquals(status, "Order placed successfully",
                "order could not be placed successfully");

    }

    @Test
    public void buyUsingCreditCard() {
        Shopper existingShopper = new Shopper.builder("spree@spree.com", "spree123").build();
        Product productToBuy = new Product.builder().name("Oversize Sweatshirt").size("XL").quantity(2).build();

        productManagement = new ProductManagement(driver);
        shopperManagement = new ShopperManagement(driver);

        shopperManagement.loginAs(existingShopper);

        productManagement.addToCart(productToBuy);
        checkout = new OrderCheckoutWithCreditCard(driver);
        String status = checkout.placeOrder();

        Assert.assertEquals(status, "Order placed successfully",
                "order could not be placed successfully");

    }
}