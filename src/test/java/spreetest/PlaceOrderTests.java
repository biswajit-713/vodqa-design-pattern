package spreetest;

import behaviour.payment.OrderCheckout;
import behaviour.product.ProductManagement;
import behaviour.usermanagement.ShopperManagement;
import entity.Product;
import entity.Shopper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import spreetest.base.BaseTest;

public class PlaceOrderTests extends BaseTest {

    private ProductManagement productManagement;
    private ShopperManagement shopperManagement;
    private OrderCheckout checkout;

    @Test(dataProvider = "getPaymentMethod")
    public void buyUsingPaymentMethodTest(String paymentMethod) {

        Shopper existingShopper = new Shopper.builder("spree@spree.com", "spree123").build();
        Product productToBuy = new Product.builder().name("Oversize Sweatshirt").size("XL").quantity(2).build();

        productManagement = new ProductManagement(driver);
        shopperManagement = new ShopperManagement(driver);

        shopperManagement.loginAs(existingShopper);
        productManagement.addToCart(productToBuy);
        checkout = new OrderCheckout(driver, paymentMethod);
        String status = checkout.placeOrder();

        Assert.assertEquals(status, "Order placed successfully",
                "order could not be placed successfully");

    }

    @DataProvider
    public Object[][] getPaymentMethod(){
        Object[][] paymentMethods = new Object[2][1];
        paymentMethods[0][0] = "Check";
        paymentMethods[1][0] = "CreditCard";
        return paymentMethods;
    }
}
