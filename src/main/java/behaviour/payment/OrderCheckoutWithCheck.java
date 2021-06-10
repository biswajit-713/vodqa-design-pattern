package behaviour.payment;

import org.openqa.selenium.WebDriver;
import page.checkout.PaymentPage;

public class OrderCheckoutWithCheck extends OrderCheckout {

    private final PaymentPage paymentPage;

    public OrderCheckoutWithCheck(WebDriver driver) {
        super(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Override
    protected void pay() {
        paymentPage.getCheck().click();
    }

}
