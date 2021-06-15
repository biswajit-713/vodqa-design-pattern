package behaviour.payment;

import org.openqa.selenium.WebDriver;
import page.checkout.PaymentPage;
import strategy.PaymentMethods;

public class OrderCheckoutWithCheck extends OrderCheckout implements PaymentMethods {

    private final PaymentPage paymentPage;

    public OrderCheckoutWithCheck(WebDriver driver) {
        super(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Override
    public void pay() {
        paymentPage.getCheck().click();
    }

}
