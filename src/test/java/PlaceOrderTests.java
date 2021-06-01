import behaviour.cart.ShoppingCart;
import behaviour.payment.OrderPayment;
import behaviour.payment.OrderPaymentWithSafePay;
import behaviour.product.ProductManagement;
import behaviour.usermanagement.MyAccount;
import behaviour.usermanagement.ShopperManagement;
import behaviour.usermanagement.ShopperRegistration;
import com.google.common.util.concurrent.Uninterruptibles;
import entity.Shopper;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LandingPage;

import java.util.concurrent.TimeUnit;

public class PlaceOrderTests {

    WebDriver driver;
    private OrderPayment orderPayment;
    private ProductManagement product;
    private ShoppingCart shoppingCart;

    private ShopperManagement shopperManagement;
    private MyAccount myAccount;

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getInstance().getDriver();
        this.driver.get("https://demo.spreecommerce.org/");
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        shopperManagement = new ShopperManagement(driver);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void buyUsingCheckTest() {

        Shopper existingShopper = new Shopper
                .ShopperBuilder("biswajit.pattanayak@spree.com", "spree")
                .build();

        orderPayment = new OrderPaymentWithSafePay(driver);

        shopperManagement.loginAs(existingShopper);

        product.addToCart("jackets");
//        shoppingCart.checkout();
//        orderPayment.placeOrder();
    }
}