package behaviour.payment;

import behaviour.payment.strategy.PaymentMethods;
import org.openqa.selenium.WebDriver;
import page.checkout.PaymentPage;

public class OrderCheckoutWithCheck implements PaymentMethods {

    private final PaymentPage paymentPage;

    public OrderCheckoutWithCheck(WebDriver driver) {
        paymentPage = new PaymentPage(driver);
    }

    @Override
    public void pay() {
        paymentPage.getCheck().click();
    }

}
